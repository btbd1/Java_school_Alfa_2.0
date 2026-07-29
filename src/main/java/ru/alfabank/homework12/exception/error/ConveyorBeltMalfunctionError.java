package ru.alfabank.homework12.exception.error;

public class ConveyorBeltMalfunctionError extends Error {

  private final String conveyorBeltId;
  private final String malfunctionType;  // тип поломки
  private final long timestamp;

  public ConveyorBeltMalfunctionError(String conveyorBeltId, String malfunctionType) {
    super(String.format("ВНИМАНИЕ: Конвейерная лента %s вышла из строя. Причина: %s. " +
            "НЕМЕДЛЕННО остановите приём багажа и вызовите техническую службу.",
        conveyorBeltId, malfunctionType));
    this.conveyorBeltId = conveyorBeltId;
    this.malfunctionType = malfunctionType;
    this.timestamp = System.currentTimeMillis();
  }

  public ConveyorBeltMalfunctionError(String conveyorBeltId, String malfunctionType, Throwable cause) {
    super(String.format("ВНИМАНИЕ: Конвейерная лента %s вышла из строя. Причина: %s.",
        conveyorBeltId, malfunctionType), cause);
    this.conveyorBeltId = conveyorBeltId;
    this.malfunctionType = malfunctionType;
    this.timestamp = System.currentTimeMillis();
  }

  public String getConveyorBeltId() {
    return conveyorBeltId;
  }

  public String getMalfunctionType() {
    return malfunctionType;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public String getFormattedTimestamp() {
    return new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm:ss")
        .format(new java.util.Date(timestamp));
  }
}