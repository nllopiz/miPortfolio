import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AutenticacionService } from 'src/app/servicios/autenticacion.service';
import { DatosPorfolioService } from 'src/app/servicios/datos-porfolio.service';


@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {
  
  //defino la variable que contendrá los datos
  misdatos:any;
  //defino la variable usuario autenticado
  usuarioAutenticado: any;
  id: number = Number(this.activatedRoute.snapshot.paramMap.get('id'));

  //en el constructor especificamos el servicio que trae los datos
  constructor(
    private datosPortfolioServicio: DatosPorfolioService, 
    private autenticacionServicio: AutenticacionService,
    private activatedRoute: ActivatedRoute,
    private toaster: ToastrService
  ) { }

  ngOnInit(): void {
    //ejecutamos la función que trae los datos del servicio, y suscribimos al observable
    this.datosPortfolioServicio.verPersona().subscribe(data => {
      this.misdatos=data;
    });
    this.usuarioAutenticado = this.autenticacionServicio.usuarioAutenticado.tokenDeAcceso;
  }

}
