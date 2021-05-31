import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import Driver from 'src/app/model/driver.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DriverService {

  constructor(private http:HttpClient) { }

  async getDriver():Promise<Driver[]>{
    return JSON.parse(JSON.stringify(await this.http.get(`${environment.back}/drivers`).toPromise()));
  }

  async addDriver(driver:Driver):Promise<any>{
    return await this.http.post(`${environment.back}/addDriver`,driver).toPromise();
  }

  async getDriverById(driverId: number):Promise<Driver[]>{
    return JSON.parse(JSON.stringify(await this.http.get(`${environment.back}/driver/${driverId}`).toPromise()));
  }

}
