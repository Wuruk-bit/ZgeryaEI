package ru.ZgeryaEI.telegrambot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.ZgeryaEI.telegrambot.model.Category;
import ru.ZgeryaEI.telegrambot.model.Product;
import ru.ZgeryaEI.telegrambot.repository.CategoryRepository;
import ru.ZgeryaEI.telegrambot.methods.CategoryMethods;
import ru.ZgeryaEI.telegrambot.methods.ProductMethods;

import java.util.List;

@SpringBootTest
public class CategoryTests {

    @Autowired
    ProductMethods productMethods;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMethods categoryMethods;


    void createCategory() {
        // Создаем категории
        Category pizza = categoryMethods.createCategory("Пицца", 0L);
        Long pizzaId = pizza.getId();
        Category rolls = categoryMethods.createCategory("Роллы", 0L);
        Long rollsId = rolls.getId();
        Category burgers = categoryMethods.createCategory("Бургеры", 0L);
        Long burgersId = burgers.getId();
        Category drinks = categoryMethods.createCategory("Напитки", 0L);
        Long drinksId = drinks.getId();
        // Создаем подкатегории для роллов
        Category classicRolls = categoryMethods.createCategory("Классические роллы", rollsId);
        Category bakedRolls = categoryMethods.createCategory("Запеченные роллы", rollsId);
        Category sweetRolls = categoryMethods.createCategory("Сладкие роллы", rollsId);
        Category setRolls = categoryMethods.createCategory("Наборы", rollsId);
        // Создаем подкатегории для бургеров
        Category classicBurgers = categoryMethods.createCategory("Классические бургеры", burgersId);
        Category spicyBurgers = categoryMethods.createCategory("Острые бургеры", burgersId);
        // Создаем подкатегории для напитков
        Category soda = categoryMethods.createCategory("Газировка", drinksId);
        Category energetics = categoryMethods.createCategory("Энергетики", drinksId);
        Category juice = categoryMethods.createCategory("Соки", drinksId);
        Category other = categoryMethods.createCategory("Другие", drinksId);
    }

    @Test
    void createProductsInCategories() {
        createCategory();
        // Создаем товары для категории "Пицца"
        Category pizza = categoryMethods.findByName("Пицца");
        Category classicRolls = categoryMethods.findByName("Классические роллы");
        Product pizza1 = productMethods.createProduct("Четыре сезона", "1", 100.0, pizza);
        Product pizza2 = productMethods.createProduct("Маргарита", "2", 110.0, pizza);
        Product pizza3 = productMethods.createProduct("Цезарь", "3", 130.0, pizza);

        // Создаем товары для категории "Классические роллы"
        Product roll1 = productMethods.createProduct("Креветковый", "1", 220.0, classicRolls);
        Product roll2 = productMethods.createProduct("Лососевый", "2", 170.0, classicRolls);
        Product roll3 = productMethods.createProduct("Канада", "3", 180.0, classicRolls);

        // Создаем товары для категории "Запеченные роллы"
        Category bakedRolls = categoryMethods.findByName("Запеченные роллы");
        Product bakedRoll1 = productMethods.createProduct("Запеченный острый", "1", 180.0, bakedRolls);
        Product bakedRoll2 = productMethods.createProduct("Запеченный с лососем", "2", 200.0, bakedRolls);
        Product bakedRoll3 = productMethods.createProduct("Запеченный с тунцом", "3", 190.0, bakedRolls);

        // Создаем товары для категории "Сладкие роллы"
        Category sweetRolls = categoryMethods.findByName("Сладкие роллы");
        Product sweetRoll1 = productMethods.createProduct("Малиновый ролл", "1", 120.0, sweetRolls);
        Product sweetRoll2 = productMethods.createProduct("Шоколадный ролл", "2", 250.0, sweetRolls);
        Product sweetRoll3 = productMethods.createProduct("Яблоко ролл", "3", 120.0, sweetRolls);

        // Создаем товары для категории "Классические бургеры"
        Category classicBurgers = categoryMethods.findByName("Классические бургеры");
        Product burger1 = productMethods.createProduct("Гамбургер", "1", 200.0, classicBurgers);
        Product burger2 = productMethods.createProduct("Макчикен", "2", 220.0, classicBurgers);
        Product burger3 = productMethods.createProduct("Крабсбургер", "3", 300.0, classicBurgers);

        // Создаем товары для категории "Острые бургеры"
        Category spicyBurgers = categoryMethods.findByName("Острые бургеры");
        Product spicyBurger1 = productMethods.createProduct("Острый бургер", "1", 250.0, spicyBurgers);
        Product spicyBurger2 = productMethods.createProduct("Очень острый бургер", "2", 300.0, spicyBurgers);
        Product spicyBurger3 = productMethods.createProduct("Мега острый бургер", "3", 350.0, spicyBurgers);

        // Создаем товары для категории "Газированные напитки"
        Category soda = categoryMethods.findByName("Газированные напитки");
        Product drink1 = productMethods.createProduct("Кола", "1", 70.0, soda);
        Product drink2 = productMethods.createProduct("Швепс", "2", 80.0, soda);
        Product drink3 = productMethods.createProduct("Спрайт", "3", 70.0, soda);

        // Создаем товары для категории "Энергетические напитки"
        Category energetics = categoryMethods.findByName("Энергетические напитки");
        Product energetic1 = productMethods.createProduct("Бояринъ", "1", 120.0, energetics);
        Product energetic2 = productMethods.createProduct("Озверин", "2", 140.0, energetics);
        Product energetic3 = productMethods.createProduct("Мотор", "3", 160.0, energetics);

        // Создаем товары для категории "Соки"
        Category juices = categoryMethods.findByName("Соки");
        Product juice1 = productMethods.createProduct("Апельсиновый", "1", 70.0, juices);
        Product juice2 = productMethods.createProduct("Мультифрукт", "2", 70.0, juices);
        Product juice3 = productMethods.createProduct("Томатный", "3", 80.0, juices);

        // Создаем товары для категории "Другие"
        Category other = categoryMethods.findByName("Другие");
        Product other1 = productMethods.createProduct("Минералньая вода", "1", 35.0, other);
        Product other2 = productMethods.createProduct("Коктейль в аортименте", "2", 120.0, other);
        Product other3 = productMethods.createProduct("Молочный коктейль", "3", 150.0, other);

        productMethods.saveAll(List.of(pizza1, pizza2, pizza3, roll1, roll2, roll3,
                bakedRoll1, bakedRoll2, bakedRoll3, sweetRoll1, sweetRoll2, sweetRoll3,
                burger1, burger2, burger3, spicyBurger1, spicyBurger2, spicyBurger3,
                drink1, drink2, drink3, energetic1, energetic2, energetic3,
                juice1, juice2, juice3, other1, other2, other3));
    }

}