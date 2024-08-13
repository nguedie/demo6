package com.example.demo.Utilite;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Component
@AllArgsConstructor
@Slf4j
public class Utils {
    private final ObjectMapper objectMapper;
    public String convertDataToJsonString(Object data) {
        try {
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            log.error("Error converting object {} to jsonString", data);
            throw new RuntimeException(e);
        }
    }

    public <T> T convertDataObjectFromJsonString(String data, Class<T> aClass) {
        try {
            return objectMapper.readValue(data, aClass);
        } catch (JsonProcessingException e) {
            log.error("Error converting data {} to class {}", data, aClass);
            throw new RuntimeException(e);

        }
    }
    public LocalDateTime convertStringToLocalDateTime(String stringDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        LocalDateTime dateTime = LocalDateTime.parse(stringDateTime, formatter);
        return dateTime;
    }
    public LocalDate convertStringToLocalDate(String stringDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, formatter);
        return date;
    }
    public LocalDateTime getCurrencenDateTime(){
        var actualDateTime = LocalDateTime.now(ZoneId.of("Africa/Douala"));

        log.info("actual date time is:{}",actualDateTime);
        return actualDateTime;
    }
    public LocalDate getCurrenDate(){
        var actualDate=LocalDate.now(ZoneId.of("Africa/Douala"));
        log.info("actual date is:{}",actualDate);
        return actualDate;
    }
}