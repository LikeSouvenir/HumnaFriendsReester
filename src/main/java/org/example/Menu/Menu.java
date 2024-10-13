package org.example.Menu;

import org.example.Base.Base;
import org.example.Menu.Parts.Adds;
import org.example.Menu.Parts.Change;
import org.example.Menu.Parts.Looks;
import org.example.ReesterCategories.Cats;
import org.example.ReesterCategories.Dogs;
import org.example.ReesterCategories.Enums.Gender;
import org.example.ReesterCategories.Enums.TypeHarness;
import org.example.ReesterCategories.Enums.WorkType;
import org.example.ReesterCategories.Hoofeds;
import org.example.ReesterCategories.Human;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Base base = new Base();
    Adds adds = new Adds(base);
    Change change = new Change(base);
    Looks looks = new Looks(base);

    public void startMenu() {
        addBaseInformations();
        while (true) {
            System.out.println("Для выхода введите 0\n" +
                    "Меню\n" +
                    "   1)Посмотреть\n" +
                    "   2)Добавить человека\n" +
                    "   3)Завести животное\n" +
                    "   4)Изменить\n");
            int choice = -1;
            String input = scanner.nextLine();
            if (input.equals("0")) return;
            try {
                choice = Integer.parseInt(input);
                if (choice > 4 || choice < 0)
                    System.out.println("Неверный ввод, попробуйте еще раз");
                else {
                    if (choice == 1) see();
                    else if (choice == 2) addHuman();
                    else if (choice == 3) addAnimal();
                    else if (choice == 4) change();
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный ввод, попробуйте еще раз");
            }
        }
    }

    private void change() {
        while (true) {
            System.out.println("Для выхода введите 0\n" +
                    "1)Поменять хозяина\n" +
                    "2)Изменить сбрую\n" +
                    "3)Изменить тип работы\n" +
                    "4)Добавить команду\n" +
                    "5)Удалить команду");
            int choice;
            String input = scanner.nextLine();
            if (input.equals("0")) return;
            try {
                choice = Integer.parseInt(input);
                if (choice > 6 || choice < 0)
                    System.out.println("Неверный ввод, попробуйте еще раз");
                else if (choice == 1) chacngeOwner();
                else if (choice == 2) chacngeHarness();
                else if (choice == 3) chacngeWorkType();
                else if (choice == 4) addCommand();
                else if (choice == 5) rmCommand();
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный ввод, попробуйте еще раз");
            }
        }
    }

    private void rmCommand() {baseRmOrAddCommand(false);}

    private void addCommand() {baseRmOrAddCommand(true);}

    private void baseRmOrAddCommand(boolean addOrRm) {
        while (true) {
            System.out.println("Для выхода введите 0\n" +
                    "(Только для собак и копытных)\n" +
                    "Введите ID животного:");
            try {
                int idAnimal = scanner.nextInt();
                if (idAnimal == 0) return;
                if (base.getCountAnimals() > idAnimal && idAnimal > 0)
                {
                    boolean check;
                    if (!change.checkHoofeds(idAnimal) || !change.checkDogs(idAnimal))
                        System.out.println("Только для собак и копытных, id не верный");
                    else while (true) {
                        System.out.println("Для выхода введите 0\n" +
                                "Введите команду");
                        String command = scanner.nextLine();
                        if (command.equals("0")) return;
                        if (addOrRm) {
                            check = change.addCommands(idAnimal, command);
                        } else{
                            check = change.rmCommands(idAnimal, command);
                        }
                        if (check) System.out.println("Успешно");
                        else System.out.println("Ошибка");
                    }
                }
                else System.out.println("Id не найдено в базе");
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный ввод, попробуйте еще раз");
            }
        }
    }

    private void chacngeWorkType() {
        while (true) {
            System.out.println("Для выхода введите 0\n" +
                    "(Только для копытных)\n" +
                    "Введите ID животного:");
            try {
                int idAnimal = scanner.nextInt();
                if (idAnimal == 0) return;
                if (base.getCountAnimals() > idAnimal && idAnimal > 0)
                {
                    if (!change.checkHoofeds(idAnimal)) System.out.println("Только для копытных, id не верный");
                    else while (true) {
                        boolean check = false;
                        System.out.println("Для выхода введите 0\n" +
                                "Выберите новый тип работы:" +
                                "1)Вьючное\n,\n" +
                                "2)Тягловое\n,\n" +
                                "3)Спортивное");
                        int workType = scanner.nextInt();
                        if (workType == 0) return;
                        else if (workType == 1) check = change.changeWorkType(idAnimal, WorkType.pack_animals);
                        else if (workType == 2) check = change.changeWorkType(idAnimal, WorkType.draft_animal);
                        else if (workType == 3) check = change.changeWorkType(idAnimal, WorkType.sports);
                        else System.out.println("Неверный ввод, попробуйте еще раз");
                        if (check) System.out.println("Успешно");
                        else System.out.println("Ошибка");
                    }

                }
                else System.out.println("Id не найдено в базе");
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный ввод, попробуйте еще раз");
            }
        }
    }

    private void chacngeHarness() {
        while (true) {
            System.out.println("Для выхода введите 0\n" +
                    "(Только для копытных)\n" +
                    "Введите ID животного:");
            try {
                int idAnimal = scanner.nextInt();
                if (idAnimal == 0) return;
                if (base.getCountAnimals() > idAnimal && idAnimal > 0)
                {
                    if (!change.checkHoofeds(idAnimal)) System.out.println("Только для копытных, id не верный");
                    else while (true) {
                        boolean check = false;
                        System.out.println("Для выхода введите 0\n" +
                                "Выберите новую сбрую:" +
                                "1)Arc,\n" +
                                "2)Non_arc,\n" +
                                "3)Drawbar");
                        int typeHarness = scanner.nextInt();
                        if (typeHarness == 0) return;
                        else if (typeHarness == 1) check =change.changeHarness(idAnimal, TypeHarness.arc);
                        else if (typeHarness == 2) check =change.changeHarness(idAnimal, TypeHarness.non_arc);
                        else if (typeHarness == 3) check =change.changeHarness(idAnimal, TypeHarness.drawbar);
                        else System.out.println("Неверный ввод, попробуйте еще раз");
                        if (check) System.out.println("Успешно");
                        else System.out.println("Ошибка");
                    }
                }
                else System.out.println("Id не найдено в базе");
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный ввод, попробуйте еще раз");
            }
        }
    }

    private void chacngeOwner() {
        while (true) {
            System.out.println("Для выхода введите 0\n" +
                    "Введите ID новго хозяина:");
            try {
                int idNewOwner = scanner.nextInt();
                if (idNewOwner == 0) return;
                System.out.println("Для выхода введите 0\n" +
                        "Введите ID животного:");
                int idAnimal = scanner.nextInt();
                boolean check =  change.chacngeOwner(idNewOwner, idAnimal);
                if (check) System.out.println("Успешно");
                else System.out.println("Ошибка");
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный ввод, попробуйте еще раз");
            }
        }
    }

    private void see() {
        while (true) {
            System.out.println("Для выхода введите 0\n" +
                    "1)Всю базу\n" +
                    "2)Поиск человека по id\n" +
                    "3)Поиск животного по id\n" +
                    "4)Поиск человека по имени\n" +
                    "5)Поиск человека по фамилии\n" +
                    "6)Поиск животного по кличке\n");
            int choice = -1;
            String input = scanner.nextLine();
            if (Objects.equals(input, "0")) return;
            try {
                choice = Integer.parseInt(input);
                if (choice > 6 || choice < 0)
                    System.out.println("Неверный ввод, попробуйте еще раз");
                else if (choice == 1) seeAllBase();
                else if (choice == 2) seeIDHuman();
                else if (choice == 3) seeIDAnima();
                else if (choice == 4) seeHumanName();
                else if (choice == 5) seeHumanSurname();
                else if (choice == 6) seeAnimalName();
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный ввод, попробуйте еще раз");
            }
        }
    }

    private void seeAnimalName() {
        System.out.println("Для выхода введите 0\n" +
                "Введите кличку животного: ");
        String input = scanner.nextLine();
        if (Objects.equals(input, "0")) return;
        System.out.println(looks.getAnimalName(input));
    }

    private void seeHumanSurname() {
        System.out.println("Для выхода введите 0\n" +
                "Введите фамилию человека: ");
        String input = scanner.nextLine();
        if (Objects.equals(input, "0")) return;
        System.out.println(looks.getHumanSurname(input));
    }

    private void seeHumanName() {
        System.out.println("Для выхода введите 0\n" +
                        "Введите имя человека: ");
        String input = scanner.nextLine();
        if (Objects.equals(input, "0")) return;
        System.out.println(looks.getHumanName(input));
    }

    private void seeIDAnima() {
        System.out.println("Для выхода введите 0\n" +
                "Введите id животного: ");
        String input = scanner.nextLine();
        if (Objects.equals(input, "0")) return;
        try {
            int choice = Integer.parseInt(input);
            if (base.getCountAnimals() > choice && choice > 0)
                System.out.println(looks.getAnimalID(choice));
            else System.out.println("Id не найдено в базе");
        }
        catch (NumberFormatException e) {
            System.out.println("Неверный ввод, попробуйте еще раз");
        }
    }

    private void seeIDHuman() {
        System.out.println("Для выхода введите 0\n" +
                "Введите id человека: ");
        String input = scanner.nextLine();
        if (Objects.equals(input, "0")) return;
        try {
            int choice = Integer.parseInt(input);
            if (base.getCountHumans() > choice && choice > 0)
                System.out.println(looks.getHumanID(choice));
            else System.out.println("Id не найдено в базе");
        }
        catch (NumberFormatException e) {
            System.out.println("Неверный ввод, попробуйте еще раз");
        }
    }

    private void seeAllBase() {
        System.out.println(looks.seeAllBase());
    }

    private void addAnimal() {
        while (true) {
            System.out.println("Для выхода введите 0\n" +
                    "Кого вы хотите добавить:\n" +
                    "   1)Копытное\n" +
                    "   2)Псовое\n" +
                    "   3)Котообразное");
            int choice = -1;
            String input = scanner.nextLine();
            if (Objects.equals(input, "0")) return;
            try {
                choice = Integer.parseInt(input);
            }
            catch (NumberFormatException e) {
                System.out.println("Неверный ввод, попробуйте еще раз");
            }
            if (choice > 3 || choice < 0)
                System.out.println("Неверный ввод, попробуйте еще раз");
            else {
                int idOwner;
                while (true) {
                    System.out.println("Для выхода введите 0\n" +
                            "id хозяина животного: ");
                    input = scanner.nextLine();
                    if (input.equals("0")) return;
                    try {
                        idOwner = Integer.parseInt(input);
                        if (idOwner > 0 && base.getCountHumans() > idOwner)
                            break;
                        else System.out.println("Такого id нет в системе");
                    }
                    catch (NumberFormatException e){
                        System.out.println("Неверный ввод, попробуйте еще раз");
                    }
                }
                System.out.println("Для выхода введите 0\n" +
                            "Порода: ");
                String breed = scanner.nextLine();
                if (Objects.equals(breed, "0")) return;
                System.out.println("Для выхода введите 0\n" +
                        "Имя: ");
                String name = scanner.nextLine();
                if (Objects.equals(name, "0")) return;
                System.out.println("Для выхода введите 0\n" +
                        "Пол(м, ж): ");
                input = scanner.nextLine();
                Gender gender = checkGender(input);
                Date birthday;
                SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd");
                while (true) {
                    System.out.println("Для выхода введите 0\n" +
                            "Дата рождения в формате(гггг-мм-дд): ");
                    input = scanner.nextLine();
                    if (Objects.equals(input, "0")) return;
                    try {
                        birthday = sformat.parse(input);
                        break;
                    }
                    catch (ParseException e){
                        System.out.println("Неверный ввод, попробуйте еще раз");
                    }
                }
                if (choice == 1) adds.addAnimal(new Hoofeds(name, gender, birthday, breed), idOwner);
                if (choice == 2) adds.addAnimal(new Dogs(name, gender, birthday, breed), idOwner);
                if (choice == 3) adds.addAnimal(new Cats(name, gender, birthday, breed), idOwner);
                System.out.println(name + " успешно добавлен");
            }
        }
    }

    private void addHuman() {
        boolean flag = true;
        while (flag) {
            System.out.println("Для выхода введите 0\n" +
                    "Введите через ',' по примеру - \n" +
                    "Фамилию, Имя, Пол(м, ж), Дата рождения (гггг-мм-дд)");
            scanner.useDelimiter(",");
            if (scanner.hasNextInt() && scanner.nextInt() == 0) flag = false;
            try {
                String surname = scanner.nextLine();
                String name = scanner.nextLine();
                Gender gender = checkGender(scanner.nextLine());
                SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd");
                Date birthday = sformat.parse(scanner.nextLine());
                adds.addHuman(new Human(name,surname,gender, birthday));
            } catch (Exception e) {
                System.out.println("Неверный ввод, попробуйте еще раз");
            }
        }
    }

    private Gender checkGender(String g) {
        if (g.toLowerCase().equals("ж") || g.toLowerCase().equals("g")) return Gender.female;
        else return Gender.male;
    }

    private void addBaseInformations() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            base.addHuman(new Human("Ульяна", "Фирсова", Gender.female, format.parse("1995-07-27")));
            base.addHuman(new Human("Анастасия","Сафонова", Gender.female, format.parse("2010-04-07")));
            base.addHuman(new Human("Тимур","Яковлев", Gender.male, format.parse("2015-08-27")));
            base.addHuman(new Human("Александр","Березин", Gender.male, format.parse("2000-07-03")));
            base.addAnimal(2, new Hoofeds("Рыжик",Gender.male,format.parse("2010-01-01"),"Home Horse",400));
            base.addAnimal(2, new Hoofeds("Бэла",Gender.female,format.parse("2021-11-03"),"Арабская чистокровная лошадь",420));
            base.addAnimal(2, new Hoofeds("Гвоздь",Gender.male,format.parse("2019-12-30"),"Двугорбый верблюд",500));
            base.addAnimal(2, new Hoofeds(" ",Gender.male,format.parse("2022-01-01"),"Ишак"));
            base.addAnimal(1, new Hoofeds("Олег",Gender.male,format.parse("2021-11-17"),"Двугорбый верблюд",400));
            base.addAnimal(1, new Cats("Гудрон",Gender.male,format.parse("2019-09-20"),"Мейн-Кун"));
            base.addAnimal(3, new Cats("Пышка",Gender.female,format.parse("2020-03-12"),"Австралийский мист"));
            base.addAnimal(3, new Cats("Булочка",Gender.male," "));
            base.addAnimal(3, new Cats("Муся",Gender.female,format.parse("2015-08-25"),"Британская короткошерстная"));
            base.addAnimal(3, new Cats("Кофеек",Gender.female,format.parse("2024-09-27"),"Бродячая"));
            base.addAnimal(3, new Dogs("Валенсия",Gender.female,format.parse("2020-10-01"),"Мастиф"));
            base.addAnimal(3, new Dogs("Есения",Gender.female,format.parse("2017-10-10"),"Валенсийский ратер"));
            base.addAnimal(4, new Dogs("Жасмина",Gender.female,format.parse("2022-08-18"),"Далматин"));
            base.addAnimal(4, new Dogs("Жужа",Gender.male,format.parse("2018-12-13"),"Китайская хохлатая собака"));
            base.addAnimal(4, new Dogs("Буч",Gender.male,format.parse("2019-03-26"),"Канадская эскимосская собака"));

            System.out.println("БАЗА ДОБАВЛЕНА");
        } catch (ParseException e) {}
    }
}