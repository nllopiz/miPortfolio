import { Component, OnInit } from '@angular/core';
import { DatosPorfolioService } from 'src/app/servicios/datos-porfolio.service';

@Component({
  selector: 'app-intereses',
  templateUrl: './intereses.component.html',
  styleUrls: ['./intereses.component.css']
})
export class InteresesComponent implements OnInit {

  misdatos:any;

  constructor(private datosPortflio: DatosPorfolioService) { }

  ngOnInit(): void {
    this.datosPortflio.obtenerDatos().subscribe(data => {
      this.misdatos = data;
    });
  }
}
