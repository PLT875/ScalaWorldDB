package model

import dao.DBConnection


class City (var name: String, var countryCode: String, var district: String, var population: Integer){
	override def toString() = this.name + " | " + this.countryCode + " | " + this.district + " | " + this.population
}