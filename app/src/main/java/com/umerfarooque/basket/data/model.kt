package com.umerfarooque.basket.data

sealed class Item : ItemType

data class Fruit(
    private val name: String,
    private val description: String,
    private val energy: String,
    val fiber: String,
    private val fat: String,
    private val protein: String,
    private val sugar: String,
    private val imageId: Int
) : Item() {
    override fun isFruit() = true
    override fun getName() = name
    override fun getEnergy() = energy
    override fun getFat() = fat
    override fun getProtein() = protein
    override fun getSugar() = sugar
    override fun getImageId() = imageId
    override fun getDescription() = description
}

data class Vegetable(
    private val name: String,
    private val description: String,
    private val energy: String,
    private val fat: String,
    private val protein: String,
    private val sugar: String,
    val omega3FattyAcids: String,
    val omega6FattyAcids: String,
    val vitaminA: String,
    val vitaminC: String,
    private val imageId: Int
) : Item() {
    override fun isFruit() = false
    override fun getName() = name
    override fun getEnergy() = energy
    override fun getFat() = fat
    override fun getProtein() = protein
    override fun getSugar() = sugar
    override fun getImageId() = imageId
    override fun getDescription() = description
}

interface ItemType {
    fun isFruit(): Boolean
    fun getName(): String
    fun getEnergy(): String
    fun getFat(): String
    fun getProtein(): String
    fun getSugar(): String
    fun getImageId(): Int
    fun getDescription(): String
}