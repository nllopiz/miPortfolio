import { Component, OnInit } from '@angular/core';
import { DatosPorfolioService } from 'src/app/servicios/datos-porfolio.service';


@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {
  
  //defino la variable que contendrá los datos del archivo .json
  misdatos:any;

  //en el constructor especificamos el servicio que trae los datos
  constructor(private datosPorfolio: DatosPorfolioService) { }

  ngOnInit(): void {
    //ejecutamos la función que trae los datos del servicio, y suscribimos al observable
    this.datosPorfolio.obtenerDatos().subscribe(data => {
      console.log("Datos api: " + data);
      this.misdatos=data[0];''
    });
  }

}
