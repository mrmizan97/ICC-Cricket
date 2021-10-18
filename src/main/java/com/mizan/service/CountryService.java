package com.mizan.service;

import com.mizan.config.HibernateConfig;
import com.mizan.model.Country;
import com.mizan.requestDto.CountryResponseDto;
import com.mizan.responseDto.CountryRequestDto;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryService {
    @Autowired
    private HibernateConfig hibernateConfig;
    Logger logger = LogManager.getLogger(CountryService.class);

    public List<Country> allCountries() {
        CriteriaBuilder criteriaBuilder = hibernateConfig.getCriteriaBuilder();
        CriteriaQuery<Country> criteriaQuery = criteriaBuilder.createQuery(Country.class);
        Root root = criteriaQuery.from(Country.class);
        criteriaQuery.select(root);
        List<Country> resultList = hibernateConfig.query(criteriaQuery).getResultList();
        return resultList.size() > 0 ? resultList : null;
    }

    public List<CountryResponseDto> CountryResponseDtoList() {
        List<Country> countries = allCountries();
        ArrayList<CountryResponseDto> countryResponseDtoList = new ArrayList<>();
        if (!countries.isEmpty()) {
            for (Country country : countries) {
                CountryResponseDto countryResponseDto = new CountryResponseDto();
                BeanUtils.copyProperties(country, countryResponseDto);
                countryResponseDto.setId(String.valueOf(country.getId()));
                countryResponseDto.setName(country.getName());
                if (country.getDirector() != null) {
                    countryResponseDto.setDirectorName(country.getDirector().getName());
                    countryResponseDto.setDirectorEmail(country.getDirector().getEmail());
                }
                if (country.getPlayerList().size() > 0) {
                    countryResponseDto.setPlayerNames(country.getPlayerList()
                            .stream().map(player -> player.getUserInfo().getName())
                            .collect(Collectors.toList()));
                }
                countryResponseDtoList.add(countryResponseDto);
            }
        }
        return countryResponseDtoList;
    }

    public void createCountry(CountryRequestDto countryRequestDto) {
        Country country = new Country();
        BeanUtils.copyProperties(countryRequestDto, country);
        Optional<Country> optionalCountry = Optional.empty();
        if (allCountries() != null) {
            optionalCountry = allCountries().stream().filter(country1 ->
                    country.getCountryCode().equals(country.getCountryCode()))
                    .findFirst();
        }
        if (!optionalCountry.isPresent()) {
            hibernateConfig.saveObject(country);
            logger.info("Country saved.");
        }else {
            logger.error("Country already exists.");
        }
    }
}
