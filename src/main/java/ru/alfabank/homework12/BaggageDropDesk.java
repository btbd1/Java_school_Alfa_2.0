package ru.alfabank.homework12;

import ru.alfabank.homework12.exception.checked.*;
import ru.alfabank.homework12.exception.unchecked.*;

public class BaggageDropDesk {

  // Константы
  private static final int MAX_WEIGHT = 23;

  // Поле: массив доступных рейсов
  private String[] availableFlights;

  // Конструктор
  public BaggageDropDesk(String[] availableFlights) {
    this.availableFlights = availableFlights;
  }

  // Метод для сдачи багажа
  public BaggageTicket checkInBaggage(String passengerName, String flightNumber, int weight)
      throws AirportServiceException {

    // 1. Проверка имени
    if (passengerName == null || passengerName.isEmpty()) {
      throw new InvalidPassengerNameException("Имя пассажира не может быть null или пустым");
    }

    // 2. Проверка веса на корректность
    if (weight <= 0) {
      throw new InvalidBaggageWeightException(weight);
    }

    // 3. Проверка наличия рейса
    if (!isFlightAvailable(flightNumber)) {
      throw new FlightNotFoundException(flightNumber);
    }

    // 4. Проверка веса багажа
    if (weight > MAX_WEIGHT) {
      throw new OverweightBaggageException(weight, MAX_WEIGHT);
    }

    // 5. Симуляция проблемы с печатью
    if ("AE-404".equals(flightNumber)) {
      throw new BaggageTagPrintException("Не удалось напечатать бирку для рейса " + flightNumber +
          ". Ошибка принтера: закончилась бумага");
    }

    // 6. Все проверки пройдены - создаём бирку
    BaggageTicket ticket = new BaggageTicket(passengerName, flightNumber, weight);

    // 7. Дополнительное действие (налог за правильно введённые данные)
    System.out.println("Бирка успешно создана для " + passengerName);
    System.out.println("Налог за слишком правильные введенные данные: 100 рублей. Будьте здоровы!");

    return ticket;
  }

  // Приватный вспомогательный метод для проверки наличия рейса
  private boolean isFlightAvailable(String flightNumber) {
    for (String flight : availableFlights) {
      if (flight.equals(flightNumber)) {
        return true;
      }
    }
    return false;
  }
}