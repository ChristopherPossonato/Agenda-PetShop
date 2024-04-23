package br.com.topicosnewm.petshop.utils;

import br.com.topicosnewm.petshop.dataprovider.model.Pacote;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class DataExpiracaoUtil {

    public static LocalDateTime calcularDataExpiracao(LocalDateTime dataInicio, Pacote pacote) {
        if (pacote == Pacote.DIA_UNICO) {
            return dataInicio;
        } else if (pacote == Pacote.SEMANAL) {
            int segundasNoMes = contarDiasDaSemanaNoMes(dataInicio, DayOfWeek.MONDAY);
            int semanas = segundasNoMes;
            return dataInicio.plusWeeks(semanas);
        } else if (pacote == Pacote.QUINZENAL) {
            int segundasNoMes = contarDiasDaSemanaNoMes(dataInicio, DayOfWeek.MONDAY);
            int semanas = segundasNoMes / 2; // Divide por 2 para calcular as semanas
            return dataInicio.plusWeeks(semanas);
        } else if (pacote == Pacote.MENSAL) {
            LocalDateTime inicioProximoMes = dataInicio.plusMonths(1).with(TemporalAdjusters.firstDayOfMonth());
            return inicioProximoMes.minusDays(1);
        } else {
            throw new IllegalArgumentException("Pacote inválido");
        }
    }

    public static int contarDiasDaSemanaNoMes(LocalDateTime data, DayOfWeek diaDaSemana) {
        LocalDateTime inicioMes = data.with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime finalMes = data.with(TemporalAdjusters.lastDayOfMonth());

        int count = 0;
        while (inicioMes.isBefore(finalMes) || inicioMes.isEqual(finalMes)) {
            if (inicioMes.getDayOfWeek() == diaDaSemana) {
                count++;
            }
            inicioMes = inicioMes.plusDays(1);
        }
        return count;
    }
}