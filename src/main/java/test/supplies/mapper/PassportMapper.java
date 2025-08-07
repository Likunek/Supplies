package test.supplies.mapper;

import test.supplies.dto.PassportDto;
import test.supplies.dto.TransportDto;
import test.supplies.model.Firm;
import test.supplies.model.Passport;
import test.supplies.model.Type;
import test.supplies.model.View;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PassportMapper {

    static public Passport toPassport(PassportDto passportDto, Type type, Firm firm) {
        Passport passport = new Passport();
        passport.setId(passportDto.getId());
        passport.setNumber(passportDto.getNumber());
        passport.setType(type);
        passport.setFirm(firm);
        passport.setTonnage(passportDto.getTonnage());
        passport.setNormExpense(passportDto.getNormExpense());
        passport.setDateEnd(LocalDate.parse(passportDto.getDateEnd(), DateTimeFormatter.ofPattern("yyyy.MM.dd")));
        return passport;
    }
    static public PassportDto toPassportDto(Passport passport) {
        return PassportDto
                .builder()
                .id(passport.getId())
                .number(passport.getNumber())
                .type(passport.getType().getId())
                .firm(passport.getFirm().getId())
                .tonnage(passport.getTonnage())
                .normExpense(passport.getNormExpense())
                .dateEnd(passport.getDateEnd().toString())
                .build();
    }

    static public TransportDto toTransport(PassportDto passport, Firm firm, Type type, View view) {
        return  TransportDto
                .builder()
                .firm(firm.getName())
                .type(type.getName())
                .view(view.getName())
                .passport(passport)
                .build();
    }
}
