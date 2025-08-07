package test.supplies.mapper;

import test.supplies.dto.ListTrailerDto;
import test.supplies.model.ListTrailer;
import test.supplies.model.Passport;
import test.supplies.model.Waybill;

public class TrailerListMapper {
    static public ListTrailer toListTrailer(ListTrailerDto listTrailerDto, Passport passport, Waybill waybill) {
        ListTrailer listTrailer = new ListTrailer();
        listTrailer.setId(listTrailerDto.getId());
        listTrailer.setPts(passport);
        listTrailer.setCargoVolume(listTrailerDto.getCargoVolume());
        listTrailer.setWaybill(waybill);
        return listTrailer;
    }

    static public ListTrailerDto toListTrailerDto(ListTrailer listTrailer) {
        return ListTrailerDto
                .builder()
                .id(listTrailer.getId())
                .idTrailer(listTrailer.getPts().getId())
                .cargoVolume(listTrailer.getCargoVolume())
                .idWaybill(listTrailer.getWaybill().getId())
                .build();
    }
}
