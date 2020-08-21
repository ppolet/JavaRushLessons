//// https://javarush.ru/quests/lectures/questcollections.level01.lecture15
//// https://gitlab.resprojects.ru/mrresident/jrhw/-/blob/master/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task20/task2028/%D0%A3%D1%81%D0%BB%D0%BE%D0%B2%D0%B8%D0%B5.jrtc
package javarushlessons.questcollectionsl0115;
/*
Построй дерево(5)

Добавлять в дерево элементы мы можем, теперь займись удалением:
необходимо реализовать метод remove(Object o), который будет удалять элемент дерева имя которого было полученного в качестве параметра.

Если переданный объект не является строкой, метод должен бросить UnsupportedOperationException.
Если в дереве присутствует несколько элементов с переданным именем - можешь удалить только первый найденный.

Не забывай сверять поведение своего дерева с картинкой:
http://info.javarush.ru/uploads/images/00/04/89/2014/03/21/ee9a9b.jpg

Что будет если удалить из дерева элементы "3", "4", "5" и "6", а затем попытаемся добавить новый елемент?
В таком случае элементы "1" и "2" должны восстановить возможность иметь потомков (возможно придется внести изменения в метод add()).


Требования:
1.	После удаления последнего добавленного элемента из дерева с помощью метода remove, метод size должен возвращать N-1.
2.	После удаления второго элемента добавленного в дерево, метод size должен возвращать N/2 + 1 (для случаев где N > 2 и является степенью двойки), N - размер дерева до удаления.
3.	Если переданный объект не является строкой, метод remove() должен бросить UnsupportedOperationException.
4.	Если ни один элемент не способен иметь потомков, необходимо восстановить такую возможность.


Построй дерево(4)

Любое дерево начинается с корня, поэтому не забудь в класс CustomTree добавить поле root типа Entry<String> c модификатором доступа по умолчанию.
Инициируй его в конструкторе CustomTree, имя (elementName) не важно.

Итак, основа дерева создана, пора тебе поработать немного самому.
Вспомним как должно выглядеть наше дерево.

Элементы дерева должны следовать так как показано на картинке:
http://info.javarush.ru/uploads/images/00/04/89/2014/03/21/ee9a9b.jpg

Необходимо написать методы, которые бы позволили создать такую структуру дерева и проводить операции над ней.
Тебе необходимо:
1) переопределить метод add(String s) - добавляет элементы дерева, в качестве параметра принимает имя элемента(elementName), искать место для вставки начинаем слева направо.
2) переопределить метод size() - возвращает текущее количество элементов в дереве.
3) реализовать метод getParent(String s) - возвращает имя родителя элемента дерева, имя которого было полученного в качестве параметра.

Если необходимо, можешь вводить дополнительные методы и поля, не указанные в задании.



Построй дерево(3)

Класс описывающий дерево мы создали, теперь нужен класс описывающий тип элементов дерева:
1) В классе CustomTree создай вложенный статический параметризированный класс Entry<T> с модификатором доступа по умолчанию.
2) Обеспечь поддержку этим классом интерфейса Serializable.
3) Создай такие поля (модификатор доступа по умолчанию):
- String elementName;
- boolean availableToAddLeftChildren, availableToAddRightChildren;
- Entry<T> parent, leftChild, rightChild;
- при необходимости, можешь создавать и другие поля;
4) Реализуй публичный конструктор с одним параметром типа String:
- установи поле elementName равным полученному параметру;
- установи поле availableToAddLeftChildren равным true;
- установи поле availableToAddRightChildren равным true;
5) Реализуй публичный метод boolean isAvailableToAddChildren, возвращающий дизъюнкцию полей availableToAddLeftChildren и availableToAddRightChildren.



Построй дерево(2)

Несмотря на то что наше дерево является потомком класса AbstractList, это не список в привычном понимании.
В частности нам недоступны принимающие в качестве параметра индекс элемента.
Такие методы необходимо переопределить и бросить новое исключение типа UnsupportedOperationException.

Вот их список:
public String get(int index)
public String set(int index, String element)
public void add(int index, String element)
public String remove(int index)
public List<String> subList(int fromIndex, int toIndex)
protected void removeRange(int fromIndex, int toIndex)
public boolean addAll(int index, Collection<? extends String> c)



Построй дерево(1)

Амиго, похоже ты уже достаточно окреп. Самое время проверить свои навыки в большой задаче!
Сегодня реализуем свое дерево немного нестандартным способом(на базе AbstractList).
Вводную информацию можешь получить используя свой любимый поисковик и текст ниже.

Элементы дерева должны следовать так как показано на картинке:
http://info.javarush.ru/uploads/images/00/04/89/2014/03/21/ee9a9b.jpg

Для начала сделаем наше дерево потомком класса AbstractList с параметром типа String, а также
реализуем интерфейсы Cloneable и Serializable.

Реализацию методов get(int index) и size() пока оставь стандартной.

*/