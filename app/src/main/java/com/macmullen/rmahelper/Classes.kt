package com.macmullen.rmahelper

class Product constructor(brand: String, model: String, dist_company: String, accessories: List<String>) {
    var brand = brand
    var model = model
    var dist_company = dist_company
    var accessories = accessories
}

class DistributingCompany constructor(
    name: String,
    address: String,
    telephone: String,
    contact: String,
    open_hours: String,
    close_hour: String
) {
    var name = name
    var address = address
    var telephone = telephone
    var contact = contact
    var open_hours = open_hours
    var close_hour = close_hour
}