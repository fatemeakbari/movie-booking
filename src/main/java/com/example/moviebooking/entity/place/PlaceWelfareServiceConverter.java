package com.example.moviebooking.entity.place;


import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Converter
public class PlaceWelfareServiceConverter implements AttributeConverter<Set<PlaceWelfareService>,String>{
    @Override
    public String convertToDatabaseColumn(Set<PlaceWelfareService> attribute) {
        return attribute == null ? null : StringUtils.join(attribute,",");
    }

    @Override
    public Set<PlaceWelfareService> convertToEntityAttribute(String dbData) {
        if (StringUtils.isBlank(dbData))
            return Collections.emptySet();

       return Arrays.stream(dbData.split(",")).
               map(s -> PlaceWelfareService.valueOf(s)).
               collect(Collectors.toSet());
    }
}