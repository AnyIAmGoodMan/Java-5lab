import Commands.*;
import Managers.*;

import java.io.File;

/**
 * Главный класс программы.
 * Запускает приложение, инициализирует основные компоненты
 * и регистрирует команды.
 *
 * @author Daniyar
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) {
        CollectionManager cm = new CollectionManager();
        XmlReader xr = new XmlReader();
        CommandManager cmm = new CommandManager();
        Console cl = new Console(cmm);
        XmlWriter xw = new XmlWriter(cm);


        cmm.register(new HelpCommand(cmm));
        cmm.register(new ExitCommand());
        cmm.register(new InfoCommand(cm));
        cmm.register(new ShowCommand(cm));
        cmm.register(new AddCommand(cm));
        cmm.register(new AddIfMinCommand(cm));
        cmm.register(new ClearCommand(cm));
        cmm.register(new CountByDifficultyCommand(cm));
        cmm.register(new ExecuteScriptCommand(cmm));
        cmm.register(new FilterContainsName(cm));
        cmm.register(new HistoryCommand(cmm));
        cmm.register(new PrintFieldDescendingDifficultyCommand(cm));
        cmm.register(new RemoveByIdCommand(cm));
        cmm.register(new RemoveHeadCommand(cm));
        cmm.register(new SaveCommand(xw));
        cmm.register(new UpdateIdCommand(cm));

        if (args.length == 0) {
            System.out.println("Неправильное название программы");
            System.exit(0);
        }
        String fileName = args[0];
        try {
            xr.read(fileName, cm);
            cl.run();
        } catch (IllegalArgumentException e) {
            System.out.println("Этого файла не существует или у вас нет к нему доступа");
        }
    }
}
