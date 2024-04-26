package com.app.bansikajal_mapd711_project.common

import com.app.bansikajal_mapd711_project.R
import com.app.bansikajal_mapd711_project.model.Product

class Common {
    companion object {
        var cartList: ArrayList<Product> = ArrayList()

        fun getMenProductList(): ArrayList<Product> {
            var list = ArrayList<Product>()
            list.add(
                Product(
                    R.drawable.men_1, "Men Pink Slim Fit Casual Shirt",
                    "Dennis Lingo", 10, arrayListOf("38", "40", "42", "44", "46"),
                    category = kMen
                )
            )
            list.add(
                Product(
                    R.drawable.men_2, "Men Pink & White Slim Fit Checked Casual Shirt",
                    "HIGHLANDER", 11, arrayListOf("39", "40", "42", "44"),
                    category = kMen
                )
            )
            list.add(
                Product(
                    R.drawable.men_3, "Men Navy Blue Solid Sweatshirt",
                    "HIGHLANDER", 9, arrayListOf("S", "M", "L", "XL"),
                    category = kMen
                )
            )
            list.add(
                Product(
                    R.drawable.men_4, "Men White Solid Denim Jacket",
                    "HIGHLANDER", 14, arrayListOf("S", "M", "L", "XL"),
                    category = kMen
                )
            )
            list.add(
                Product(
                    R.drawable.men_5,
                    "Colourblocked Lightweight Antimicrobial Running Sporty Jacket",
                    "Technosport",
                    13,
                    arrayListOf("M", "L", "XL", "XXL"),
                    category = kMen
                )
            )
            list.add(
                Product(
                    R.drawable.men_6, "Knitted Single-breasted Formal Blazer",
                    "V-Mart", 18, arrayListOf("38", "40", "42"),
                    category = kMen
                )
            )
            list.add(
                Product(
                    R.drawable.men_7, "HANGUP Men Grey Suit",
                    "Hangup", 22, arrayListOf("36", "38", "40", "42", "44", "46"),
                    category = kMen
                )
            )
            list.add(
                Product(
                    R.drawable.men_8, "Men Black Reversible Rain Jacket",
                    "Sports52 wear", 8, arrayListOf("M", "L", "XL", "XXL"),
                    category = kMen
                )
            )
            list.add(
                Product(
                    R.drawable.men_9,
                    "The Lifestyle Co. Men Mid-Rise Tapered Fit Stretchable Jeans",
                    "Roadster",
                    9,
                    arrayListOf("28", "30", "32", "34", "36"),
                    category = kMen
                )
            )
            list.add(
                Product(
                    R.drawable.men_10, "Men Slim Fit Heavy Fade Stretchable Jeans",
                    "The Indian Garage Co", 10, arrayListOf("28", "30", "32", "34", "36"),
                    category = kMen
                )
            )
            list.add(
                Product(
                    R.drawable.men_11, "Men Maroon Jacquard Silk Kurta with Churidar",
                    "SOJANYA", 11, arrayListOf("S", "M", "L", "XL", "XXL"),
                    category = kMen
                )
            )
            list.add(
                Product(
                    R.drawable.men_12, "Men Off White & Red Sherwani With Dhoti Pants",
                    "DEYANN", 16, arrayListOf("S", "M", "L", "XL", "XXL", "3XL"),
                    category = kMen
                )
            )
            list.add(
                Product(
                    R.drawable.men_13, "Men Red & White Printed Dupion Silk Dhoti",
                    "DEYANN", 10, arrayListOf("S", "M", "L", "XL", "XXL", "3XL"),
                    category = kMen
                )
            )
            list.add(
                Product(
                    R.drawable.men_14, "Men Lifestyle Typography Printed Terry Shorts",
                    "HRX by Hrithik Roshan", 5, arrayListOf("28", "30", "32", "34", "36"),
                    category = kMen
                )
            )
            list.add(
                Product(
                    R.drawable.men_15, "Men Regular Fit Typography Lifestyle Joggers",
                    "HRX by Hrithik Roshan", 9, arrayListOf("S", "M", "L", "XL", "XXL"),
                    category = kMen
                )
            )
            list.add(
                Product(
                    R.drawable.men_16, "Men Slim Fit Antimicrobial Technology Sports Track Pants",
                    "Technosport", 8, arrayListOf("M", "L", "XL", "XXL"),
                    category = kMen
                )
            )
            list.add(
                Product(
                    R.drawable.men_17, "Men Pink Slim Fit Casual Shirt",
                    "The Indian Garage Co", 7, arrayListOf("S", "M", "L", "XL", "XXL"),
                    category = kMen
                )
            )
            list.add(
                Product(
                    R.drawable.men_18, "Men Striped Thermal Set",
                    "HAP", 7, arrayListOf("XS", "S", "M", "L", "XL", "XXL", "3XL", "4XL"),
                    category = kMen
                )
            )
            list.add(
                Product(
                    R.drawable.men_19, "Pack Of 2 Cotton Ribbed Thermal Tops",
                    "INFERNO", 5, arrayListOf("XS", "S", "M", "L", "XL", "XXL", "3XL", "4XL"),
                    category = kMen
                )
            )
            list.add(
                Product(
                    R.drawable.men_20, "Men Formal Trousers",
                    "Cantabil", 18, arrayListOf("30", "32", "34", "36", "38", "40"),
                    category = kMen
                )
            )
            return list
        }

        fun getWomenProductList(): ArrayList<Product> {
            var list = ArrayList<Product>()
            list.add(
                Product(
                    R.drawable.brown_black_skirt, "Black denim maxi skirt",
                    "Mango", 56, arrayListOf("XS", "S", "M", "L", "XL"),
                    category = kWomen
                )
            )
            list.add(
                Product(
                    R.drawable.brown_skirt, "Fine corduroy midi skirt",
                    "H&m", 56, arrayListOf("XS", "S", "M", "L", "XL"),
                    category = kWomen
                )
            )
            list.add(
                Product(
                    R.drawable.shorts, "Patch pockets pure linen shorts",
                    "Simons", 56, arrayListOf("XS", "S", "M", "L", "XL"),
                    category = kWomen
                )
            )
            list.add(
                Product(
                    R.drawable.white_shirt, "Plain V Neck Regular Fit Elegant Blouse",
                    "H&m", 56, arrayListOf("XS", "S", "M", "L", "XL"),
                    category = kWomen
                )
            )
            list.add(
                Product(
                    R.drawable.brown_long, "Plain turtleneck T-shirt",
                    "Lulu Lemon", 34, arrayListOf("XS", "S", "M", "L", "XL"),
                    category = kWomen
                )
            )
            list.add(
                Product(
                    R.drawable.wool_blend_sweater, "Collared Merino Wool-Blend Sweater",
                    "Lulu Lemon", 89, arrayListOf("XS", "S", "M", "L", "XL"),
                    category = kWomen
                )
            )
            list.add(
                Product(
                    R.drawable.black_stripes, "Jacquard stripe T-shirt",
                    "Icone", 89, arrayListOf("XS", "S", "M", "L", "XL"),
                    category = kWomen
                )
            )
            list.add(
                Product(
                    R.drawable.cap, "Lined-back recycled wool overcoat",
                    "ZARA", 59, arrayListOf("XS", "S", "M", "L", "XL"),
                    category = kWomen
                )
            )
            list.add(
                Product(
                    R.drawable.white_sweater, "Cotton-Blend Cardigan",
                    "HIGHLANDER", 67, arrayListOf("S", "M", "L", "XL"),
                    category = kWomen
                )
            )
            list.add(
                Product(
                    R.drawable.black_tshirt, "Merino Wool-Blend Ribbed Turtleneck Sweater",
                    "HIGHLANDER", 50, arrayListOf("S", "M", "L", "XL"),
                    category = kWomen
                )
            )
            list.add(
                Product(
                    R.drawable.white_green_border,
                    "Women's Nyala Sweater",
                    "KOTN",
                    39,
                    arrayListOf("M", "L", "XL", "XXL"),
                    category = kWomen
                )
            )
            return list
        }

        fun getCareProductList(): ArrayList<Product> {
            var list = ArrayList<Product>()
            list.add(
                Product(
                    R.drawable.poppy, "Ultimate Hydration Body Cream",
                    "Sports52 wear", 8, arrayListOf("8ml", "16ml"),
                    category = kSelfCare
                )
            )
            list.add(
                Product(
                    R.drawable.green_bottel,
                    "Daily Nourishing Body Lotion",
                    "Minimalist",
                    9,
                    arrayListOf("34ml", "67ml"),
                    category = kSelfCare
                )
            )
            list.add(
                Product(
                    R.drawable.red_bottle, "Eau De Parfum",
                    "Luminous", 10, arrayListOf("8ml", "20ml"),
                    category = kSelfCare
                )
            )
            list.add(
                Product(
                    R.drawable.gift_set, "Gift Bag Set",
                    "Lakme", 11, arrayListOf("9ml", "18ml"),
                    category = kSelfCare
                )
            )
            list.add(
                Product(
                    R.drawable.pink_bottle, "Eau de Parfum",
                    "Bath&Gingham Gorgeous", 16, arrayListOf("6ml", "12ml"),
                    category = kSelfCare
                )
            )
            list.add(
                Product(
                    R.drawable.rich, "Body Butter",
                    "Coco Shea Rich Moisture", 10, arrayListOf("8ml", "16ml", "24ml"),
                    category = kSelfCare
                )
            )
            return list
        }

        fun getAccessoriesProductList(): ArrayList<Product> {
            var list = ArrayList<Product>()
            list.add(
                Product(
                    R.drawable.red_tool, "Linkax Tool Gifts for Dad Men",
                    "visitez", 10, arrayListOf("Big","Small"),
                    category = kAccessories
                )
            )
            list.add(
                Product(
                    R.drawable.red_round, "CARELITE Lampe de travail",
                    "visitez", 11, arrayListOf("Big","Small"),
                    category = kAccessories
                )
            )
            list.add(
                Product(
                    R.drawable.oval, "Lampe de travail temporaire à DEL 150 W",
                    "visitez", 9, arrayListOf("Big","Small"),
                    category = kAccessories
                )
            )
            list.add(
                Product(
                    R.drawable.jali, "OUSIDE Lampe de travail LED rechargeable",
                    "visitez", 14, arrayListOf("Big","Small"),
                    category = kAccessories
                )
            )
            return list
        }

        fun getKidProductList(): ArrayList<Product> {
            var list = ArrayList<Product>()
            list.add(
                Product(
                    R.drawable.kid_1, "Shawl Knit Cardigan Long Sweater ",
                    "Dennis Lingo", 10, arrayListOf("XS", "S", "M"),
                    category = kKids
                )
            )
            list.add(
                Product(
                    R.drawable.kid_2, "Versatile Ribbed Knit Long Sleeve",
                    "HIGHLANDER", 11, arrayListOf("XS", "S", "M"),
                    category = kKids
                )
            )
            list.add(
                Product(
                    R.drawable.kid_3, "Slim Fit Long Sleeve T-shirt,",
                    "HIGHLANDER", 9, arrayListOf("S", "M", "L", "XL"),
                    category = kKids
                )
            )
            list.add(
                Product(
                    R.drawable.kid_4, "Girl's Elegant 3pcs, Ribbed Long Sleeve Top",
                    "HIGHLANDER", 14, arrayListOf("S", "M", "L", "XL"),
                    category = kKids
                )
            )
            list.add(
                Product(
                    R.drawable.kid_5,
                    "Colourblocked Antimicrobial Running Sporty Jacket",
                    "Technosport",
                    13,
                    arrayListOf("M", "L", "XL", "XXL"),
                    category = kKids
                )
            )
            return list
        }

        fun getJewelleryProductList(): ArrayList<Product> {
            var list = ArrayList<Product>()
            list.add(
                Product(
                    R.drawable.jwel_1, "Soft velvet travel jewellery box",
                    "Dennis Lingo", 10, arrayListOf("pink", "black"),
                    category = kJewellery
                )
            )
            list.add(
                Product(
                    R.drawable.jwel_2, "Shimmery Cuban-link chain",
                    "HIGHLANDER", 11, arrayListOf("Silver", "Gold"),
                    category = kJewellery
                )
            )
            list.add(
                Product(
                    R.drawable.jwel_3, "Precious pearl earrings",
                    "HIGHLANDER", 9, arrayListOf("Silver", "Gold"),
                    category = kJewellery
                )
            )
            list.add(
                Product(
                    R.drawable.jwel_4, "Azelie earrings",
                    "HIGHLANDER", 14, arrayListOf("Silver", "Gold"),
                    category = kJewellery
                )
            )
            list.add(
                Product(
                    R.drawable.jwel_5,
                    "Mini-star hoops",
                    "Swaroski",
                    13,
                    arrayListOf("Silver", "Gold"),
                    category = kJewellery
                )
            )
            return list
        }

        fun getHomeProductList(): ArrayList<Product> {
            var list = ArrayList<Product>()
            list.add(
                Product(
                    R.drawable.home_1, "Chenille knit cushion",
                    "Dennis Lingo", 10, arrayListOf("Pink", "Red"),
                    category = kHomeAndKitchen
                )
            )
            list.add(
                Product(
                    R.drawable.home_2, "Silvery snowflakes tablecloth",
                    "HIGHLANDER", 11, arrayListOf("Pink", "Red"),
                    category = kHomeAndKitchen
                )
            )
            list.add(
                Product(
                    R.drawable.home_3, "Luxurious faux-fur throw",
                    "Maison", 9, arrayListOf("Pink", "Red", "Black"),
                    category = kHomeAndKitchen
                )
            )
            list.add(
                Product(
                    R.drawable.home_4, "Small Danoise light fixture",
                    "HIGHLANDER", 14, arrayListOf("Pink", "Red"),
                    category = kHomeAndKitchen
                )
            )
            list.add(
                Product(
                    R.drawable.home_5,
                    "Rectangular mirror medicine cabinet",
                    "Simons",
                    13,
                    arrayListOf("Pink", "Red"),
                    category = kHomeAndKitchen
                )
            )
            return list
        }

        fun getGadgetsProductList(): ArrayList<Product> {
            var list = ArrayList<Product>()
            list.add(
                Product(
                    R.drawable.gad_1, "Donewin Bedside Lamp with Clock",
                    "Donewin Store", 105, arrayListOf("12Inch","16Inch"),
                    category = kGadgets
                )
            )
            list.add(
                Product(
                    R.drawable.gad_2, "Amazfit BIP 3 Pro Montre intelligente",
                    "HIGHLANDER", 119, arrayListOf("30L", "40L"),
                    category = kGadgets
                )
            )
            list.add(
                Product(
                    R.drawable.gad_3, "LG 36 27.1 Cu. Ft. Side-by-Side Refrigerator",
                    "HIGHLANDER", 900, arrayListOf("30L", "40L"),
                    category = kGadgets
                )
            )
            list.add(
                Product(
                    R.drawable.gad_4, "Stérilisateur et séchoir à biberon",
                    "HIGHLANDER", 889, arrayListOf("30L", "40L"),
                    category = kGadgets

                )
            )
            list.add(
                Product(
                    R.drawable.gad_5,
                    "Homvana Humidificateurs",
                    "Technosport",
                    13,
                    arrayListOf("30L", "40L"),
                    category = kGadgets
                )
            )
            return list
        }

        fun getProductList(pos: Int): ArrayList<Product> {
            return when (pos) {
                0 -> getMenProductList()
                1 -> getWomenProductList()
                2 -> getCareProductList()
                3 -> getAccessoriesProductList()
                4 -> getKidProductList()
                5 -> getJewelleryProductList()
                6 -> getHomeProductList()
                7 -> getGadgetsProductList()
                else -> {
                    getWomenProductList()
                }
            }
        }
    }
}
