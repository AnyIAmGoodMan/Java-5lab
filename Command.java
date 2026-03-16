/**
 * Интерфейс команды.
 * Определяет методы для получения имени команды, её описания и выполнения.
 */

public interface Command {

    String getName();

    String getDescription();

    void execute(String arg);

}