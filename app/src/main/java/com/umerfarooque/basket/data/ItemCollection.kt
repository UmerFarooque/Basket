package com.umerfarooque.basket.data

import com.umerfarooque.basket.R

class ItemCollection {

    companion object {
        fun getFruitsList(): List<Item> {
            return listOf(
                Fruit(
                    "Apple",
                    "Apples are a popular fruit, containing antioxidants, vitamins, dietary fiber, and a range of other nutrients. Due to their varied nutrient content, they may help prevent several health conditions.",
                    "207/95",
                    "2.3",
                    "0",
                    "0.4",
                    "11.8",
                    R.drawable.apple
                ),
                Fruit(
                    "Apricot",
                    "Apricots are small, yellow, tart-tasting fruits with a stone in the middle. Like most fruits, they are full of vitamins and minerals and make a great addition to a healthful diet.",
                    "153/36",
                    "2.1",
                    "0",
                    "1.0",
                    "8.0",
                    R.drawable.apricot
                ),
                Fruit(
                    "Avocado",
                    "The avocado, a tree likely originating from south-central Mexico, is classified as a member of the flowering plant family Lauraceae. The fruit of the plant, also called an avocado, is botanically a large berry containing a single large seed.",
                    "523/126",
                    "0.2",
                    "10",
                    "2.0",
                    "7.0",
                    R.drawable.avocado
                ),
                Fruit(
                    "Banana",
                    "Bananas are among the most important food crops on the planet. Bananas are a healthy source of fiber, potassium, vitamin B6, vitamin C, and various antioxidants and phytonutrients. Many types and sizes exist. Their color usually ranges from green to yellow, but some varieties are red.",
                    "375/88",
                    "2.7",
                    "0",
                    "1.2",
                    "20.4",
                    R.drawable.banana
                ),
                Fruit(
                    "Grapes",
                    "There are many types of grapes including green, red, black, yellow and pink. They grow in clusters and come in seeded and seedless varieties. Grapes offer a wealth of health benefits due to their high nutrient and antioxidant contents.",
                    "274/64",
                    "2.2",
                    "0",
                    "0.6",
                    "15.5",
                    R.drawable.grapes
                ),
                Fruit(
                    "Orange",
                    "Oranges are among the world's most popular fruits. Oranges are a healthy source of fiber, vitamin C, thiamine, folate, and antioxidants. They have multiple health benefits.",
                    "198/47",
                    "1.8",
                    "0",
                    "1.0",
                    "10.6",
                    R.drawable.orange
                )
            )
        }

        fun getVegetablesList(): List<Item> {
            return listOf(
                Vegetable(
                    "Cabbage",
                    "Cabbage is a leafy green, red, or white biennial plant grown as an annual vegetable crop for its dense-leaved heads. It is descended from the wild cabbage, and belongs to the \"cole crops\" or brassicas, meaning it is closely related to broccoli and cauliflower; Brussels sprouts; and Savoy cabbage.",
                    "24.9",
                    "0.1",
                    "1.2",
                    "3.1",
                    "0.0",
                    "17.0",
                    "98",
                    "36.6",
                    R.drawable.cabbage
                ),
                Vegetable(
                    "Kale",
                    "Kale, or leaf cabbage, belongs to a group of cabbage cultivars grown for their edible leaves, although some are used as ornamentals. Kale plants have green or purple leaves, and the central leaves do not form a head.",
                    "50.0",
                    "0.7",
                    "3.3",
                    "0.0",
                    "180.6",
                    "137.9",
                    "15376",
                    "120.0",
                    R.drawable.kale
                ),
                Vegetable(
                    "Broccoli",
                    "Broccoli is an edible green plant in the cabbage family whose large flowering head and stalk is eaten as a vegetable. The word broccoli comes from the Italian plural of broccolo, which means \"the flowering crest of a cabbage\", and is the diminutive form of brocco, meaning \"small nail\" or \"sprout\"",
                    "34.0",
                    "0.3",
                    "2.9",
                    "1.6",
                    "21.0",
                    "17.0",
                    "623.1",
                    "89.2",
                    R.drawable.broccoli
                ),
                Vegetable(
                    "Carrot",
                    "The carrot is a root vegetable, usually orange in colour, though purple, black, red, white, and yellow cultivars exist. They are a domesticated form of the wild carrot, Daucus carota, native to Europe and Southwestern Asia. The plant probably originated in Persia and was originally cultivated for its leaves and seeds.",
                    "35",
                    "0.2",
                    "0.8",
                    "4.7",
                    "-",
                    "-",
                    "835",
                    "5.9",
                    R.drawable.carrot
                )
            )
        }
    }
}
