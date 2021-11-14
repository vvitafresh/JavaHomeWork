/* Создать пакет hw7 и в нем создать перечисление (enum) Size со значениями XXS, XS, S, M, L.
Перечисление содержит метод getDescription(), возвращающий строку для XXS "Детский размер",
для остальных "Взрослый размер".
Так же перечисление должно иметь метод getEuroSize() возвращающий числовое значение (32, 34, 36, 38, 40)
соответствующее каждому размеру. Создать конструктор принимающий на вход description и euroSize.

Создать интерфейсы
- ManClothes (мужская одежда) c методом dressMan (одеть мужчину)
- WomenClothes (женская оджеда) с методом dressWomen (одеть женщину).
Эти методы не принимают параметров, а только выводят информацию о одежде (название, размер, цену, цвет).

Создать абстрактный класс Clothes (одежда) содержащий переменные размер (типа Size), стоимость, цвет.

Создать классы наследники Clothes:
- Tshirt (футболка) реализует интерфейсы ManClothes и WomenClothes,
- Pants (штаны) реализует интерфейсы ManClothes и WomenClothes,
- Skirt (юбка) реализует интерфейс WomenClothes,
- Tie (галстук) реализует интерфейс ManClothes.

Создать класс Atelier с методом main, и еще двумя статическими методами:
dressMan(Clothes[] clothes)
dressWomen(Clothes[] clothes)
на вход которых будет поступать массив, содержащий все типы одежды.
В методе main создать массив, содержащий все типы одежды, и вызвать методы dressMan и dressWomen передав туда этот массив.
Метод dressWomen выводит на консоль всю информацию о женской одежде.
Метод dressMan выводит на консоль всю информацию о мужской одежде.
В методах dressWomen и dressMan использовать оператор instanceof для определения мужская это одежда или женская.

По желанию можно использовать внутренние классы.
 */

package com.pb.antonov.hw7;

public class Atelier {
    public static void main(String[] args) {
        Tshirt tshirt = new Tshirt(Size.M, 10.0, "Синий");
        Pants pants = new Pants(Size.XXS, 5, "Желтый");
        Skirt skirt1 = new Skirt(Size.S, 15, "Красный");
        Skirt skirt2 = new Skirt(Size.XXS, 9, "Белый");
        Tie tie = new Tie(Size.L, 7, "В полоску");

        Clothes[] clothes = new Clothes[]{tshirt, pants, skirt1, skirt2, tie};
        dressMan(clothes);
        dressWoman(clothes);
    }

    public static void dressMan(Clothes[] clothes) {
        System.out.println("Мужская одежда:");
        for (Clothes cloth : clothes) {
            if (cloth instanceof ManClothes) {
                ((ManClothes) cloth).dressMan();
                System.out.println("---");
            }
        }
    }

    public static void dressWoman(Clothes[] clothes) {
        System.out.println("Женская одежда:");
        for (Clothes cloth : clothes) {
            if (cloth instanceof WomanClothes) {
                ((WomanClothes) cloth).dressWoman();
                System.out.println("---");
            }
        }
    }
}
