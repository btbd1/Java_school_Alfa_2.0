package main.java.ru.alfabank.homework13;

import java.util.List;

public class MissionReport {
  String missionName;
  List<Alien> capturedAliens;
  int squadSize;

  public MissionReport(String missionName, List<Alien> capturedAliens, int squadSize) {
    if (missionName == null || missionName.trim().isEmpty()) {
      throw new IllegalArgumentException("Название миссии не может быть пустым!");
    }

    if (squadSize < 0) {
      throw new IllegalArgumentException("Размер отряда не может быть отрицательным!");
    }

    this.missionName = missionName;
    this.capturedAliens = capturedAliens;
    this.squadSize = squadSize;
  }

  public String getMissionName() {
    return missionName;
  }
