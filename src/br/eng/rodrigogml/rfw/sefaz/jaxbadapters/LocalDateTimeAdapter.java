package br.eng.rodrigogml.rfw.sefaz.jaxbadapters;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Description: Classe utilizada para conversar o LocalDateTime no formato do XML da SEFAZ.<br>
 *
 * @author Rodrigo GML
 * @since 1.0.0 (25 de ago. de 2023)
 * @version 1.0.0 - Rodrigo GML-(...)
 */
public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {
  private final DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

  @Override
  public LocalDateTime unmarshal(String v) throws Exception {
    return LocalDateTime.parse(v, formatter);
  }

  @Override
  public String marshal(LocalDateTime v) throws Exception {
    return formatter.format(v);
  }
}