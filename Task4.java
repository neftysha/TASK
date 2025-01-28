import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Random;

public class Task4 {

    public static void main(String[] args) {
        // Задача 1: Текущая дата и время
        printCurrentDateTime();

        // Задача 2: Сравнение дат
        LocalDate date1 = LocalDate.of(2023, 12, 25);
        LocalDate date2 = LocalDate.of(2023, 12, 31);
        System.out.println(compareDates(date1, date2));

        // Задача 3: Дни до Нового года
        System.out.println("Дней до Нового года: " + daysUntilNewYear());

        // Задача 4: Проверка високосного года
        System.out.println("2024 год високосный: " + isLeapYear(2024));

        // Задача 5: Количество выходных в месяце
        System.out.println("Количество выходных в декабре 2023 года: " + countWeekendsInMonth(2023, 12));

        // Задача 6: Время выполнения метода
        measureExecutionTime();

        // Задача 7: Форматирование и парсинг даты
        System.out.println("Результат форматирования и парсинга даты: " + formatAndParseDate("25-12-2023"));

        // Задача 8: Конвертация часового пояса
        System.out.println("Конвертация времени в часовой пояс Europe/Moscow: " +
                convertToTimeZone(LocalDateTime.now(ZoneOffset.UTC), "Europe/Moscow"));

        // Задача 9: Расчёт возраста
        LocalDate birthDate = LocalDate.of(1990, 5, 15);
        System.out.println("Возраст: " + calculateAge(birthDate) + " лет");

        // Задача 10: Создание календаря месяца
        System.out.println("Календарь декабря 2023 года:");
        createMonthlyCalendar(2023, 12);

        // Задача 11: Генерация случайной даты
        System.out.println("Случайная дата: " +
                generateRandomDate(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 12, 31)));

        // Задача 12: Время до события
        LocalDateTime eventDate = LocalDateTime.of(2023, 12, 31, 23, 59);
        System.out.println("Время до события: " + timeUntilEvent(eventDate));

        // Задача 13: Расчёт рабочих часов
        LocalDateTime startOfWorkday = LocalDateTime.of(2023, 12, 25, 9, 0);
        LocalDateTime endOfWorkday = LocalDateTime.of(2023, 12, 25, 17, 0);
        System.out.println("Количество рабочих часов: " + calculateWorkingHours(startOfWorkday, endOfWorkday));

        // Задача 14: Конвертация даты с учётом локали
        System.out.println("Дата с учётом локали (ru): " +
                localeSensitiveDateConversion(LocalDate.of(2023, 12, 25), "ru"));

        // Задача 15: Определение дня недели
        System.out.println("День недели: " + getDayOfWeekInRussian(LocalDate.of(2023, 12, 25)));
    }

    // Задача 1: Текущая дата и время
    public static void printCurrentDateTime() {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Текущая дата и время: " + currentDate.atTime(currentTime).format(formatter));
    }

    // Задача 2: Сравнение дат
    public static String compareDates(LocalDate date1, LocalDate date2) {
        if (date1.isAfter(date2)) return "Дата 1 больше, чем дата 2";
        if (date1.isBefore(date2)) return "Дата 1 меньше, чем дата 2";
        return "Обе даты равны";
    }

    // Задача 3: Дни до Нового года
    public static long daysUntilNewYear() {
        LocalDate today = LocalDate.now();
        LocalDate newYear = LocalDate.of(today.getYear() + 1, 1, 1);
        return ChronoUnit.DAYS.between(today, newYear);
    }

    // Задача 4: Проверка високосного года
    public static boolean isLeapYear(int year) {
        return Year.isLeap(year);
    }

    // Задача 5: Количество выходных в месяце
    public static long countWeekendsInMonth(int year, int month) {
        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.plusMonths(1).minusDays(1);
        return start.datesUntil(end.plusDays(1))
                .filter(date -> date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY)
                .count();
    }

    // Задача 6: Время выполнения метода
    public static void measureExecutionTime() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {} // Симуляция задачи
        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (endTime - startTime) + " мс");
    }

    // Задача 7: Форматирование и парсинг даты
    public static String formatAndParseDate(String dateString) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date = LocalDate.parse(dateString, inputFormatter);
        return date.plusDays(10).format(outputFormatter);
    }

    // Задача 8: Конвертация часового пояса
    public static String convertToTimeZone(LocalDateTime dateTime, String zoneId) {
        ZonedDateTime utcTime = dateTime.atZone(ZoneOffset.UTC);
        return utcTime.withZoneSameInstant(ZoneId.of(zoneId)).toString();
    }

    // Задача 9: Расчёт возраста
    public static int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    // Задача 10: Создание календаря месяца
    public static void createMonthlyCalendar(int year, int month) {
        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.plusMonths(1).minusDays(1);
        start.datesUntil(end.plusDays(1)).forEach(date -> {
            String dayType = (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) ? "Выходной" : "Будний день";
            System.out.println(date + ": " + dayType);
        });
    }

    // Задача 11: Генерация случайной даты
    public static LocalDate generateRandomDate(LocalDate start, LocalDate end) {
        long daysBetween = ChronoUnit.DAYS.between(start, end);
        Random random = new Random();
        return start.plusDays(random.nextInt((int) daysBetween + 1));
    }

    // Задача 12: Время до события
    public static String timeUntilEvent(LocalDateTime eventDateTime) {
        Duration duration = Duration.between(LocalDateTime.now(), eventDateTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();
        return hours + " часов, " + minutes + " минут, " + seconds + " секунд";
    }

    // Задача 13: Расчёт рабочих часов
    public static long calculateWorkingHours(LocalDateTime start, LocalDateTime end) {
        long hours = 0;
        while (!start.isAfter(end)) {
            if (start.getDayOfWeek() != DayOfWeek.SATURDAY && start.getDayOfWeek() != DayOfWeek.SUNDAY) {
                hours++;
            }
            start = start.plusHours(1);
        }
        return hours;
    }

    // Задача 14: Конвертация даты с учётом локали
    public static String localeSensitiveDateConversion(LocalDate date, String localeCode) {
        Locale locale = new Locale(localeCode);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", locale);
        return date.format(formatter);
    }

    // Задача 15: Определение дня недели
    public static String getDayOfWeekInRussian(LocalDate date) {
        Locale russianLocale = new Locale("ru");
        return date.getDayOfWeek().getDisplayName(java.time.format.TextStyle.FULL, russianLocale);
    }
}
