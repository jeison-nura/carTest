import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import Car from 'src/app/model/car.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(private http:HttpClient) { }

  async getCar():Promise<Car[]>{
    return JSON.parse(JSON.stringify(await this.http.get(`${environment.back}/cars`).toPromise()));
  }

  async getCarById(carId: number):Promise<Car[]>{
    return JSON.parse(JSON.stringify(await this.http.get(`${environment.back}/car/${carId}`).toPromise()));
  }

  async addcar(car:Car):Promise<any>{
    return await this.http.post(`${environment.back}/addCar`,car).toPromise();
  }

  async updatecar(car:Car):Promise<any>{
    return await this.http.put(`${environment.back}/updateCars`,car).toPromise();
  }

  async deletecar(carId:number):Promise<any>{
    return await this.http.delete(`${environment.back}/deleteCar/${carId}`).toPromise();
  }

}
