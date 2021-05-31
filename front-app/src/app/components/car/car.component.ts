import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import Car from 'src/app/model/car.model';
import { CarService } from 'src/app/services/car/car.service';
import { DialogComponent } from '../dialog/dialog.component';


@Component({
  selector: 'app-car',
  templateUrl: './car.component.html',
  styleUrls: ['./car.component.css']
})
export class CarComponent implements OnInit {

  displayedColumns: string[] = ['id', 'placa', 'marca', 'modelo', 'driverId', 'editar', 'eliminar'];
  dataSource:Car[] = [];
  newCar:Car ={
    placa:'',
    marca:'',
    modelo:'',
    driverId: 0,
  };

  placa: string;
  modelo: string;
  marca: string;
  driverId: number;

  constructor(private carService: CarService,
    public dialog: MatDialog) { }

    
  ngOnInit(): void {
    this.carService.getCar().then((data:Car[]) =>{
      console.log(data);
      this.dataSource = data;
    })
  }

  deleteCar(carId: number):void{
    console.log('click');
    console.log(carId);
    this.carService.deletecar(carId).then(data=>{
      console.log(data);
    })
  }

 

  openDialog():void{
    const dialogRef = this.dialog.open(DialogComponent, {
      width: '250px',
      data: {placa:this.placa, marca:this.modelo, modelo: this.marca, driverId:this.driverId}
    });

    dialogRef.afterClosed().subscribe(result => {
      this.carService.addcar(result).then(data=>{
        console.log(data);
      })
      console.log('The dialog was closed');
      this.newCar = result;
    });
  }

}
