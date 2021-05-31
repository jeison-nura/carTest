import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import Distance from 'src/app/model/distance.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DistanceService {

  constructor(private http:HttpClient) { }

  async getDistance():Promise<Distance[]>{
    return JSON.parse(JSON.stringify(await this.http.get(`${environment.back}/distance`).toPromise()));
  }

  async addDistance(distance:Distance):Promise<any>{
    return await this.http.post(`${environment.back}/addDistance`,distance).toPromise();
  }

  async updateDistance(distance:Distance):Promise<any>{
    return await this.http.put(`${environment.back}/updateDistance`,distance).toPromise();
  }

}
