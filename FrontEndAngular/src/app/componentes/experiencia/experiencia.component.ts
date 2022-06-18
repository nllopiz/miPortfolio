import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { DatosPorfolioService } from 'src/app/servicios/datos-porfolio.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {

  misdatos:any;

  constructor(
    private datosPortfolio: DatosPorfolioService, 
    private toaster: ToastrService) { }

  ngOnInit(): void {
    this.datosPortfolio.obtenerDatos().subscribe(
      data => {
      this.misdatos = data;
      //console.log(this.misdatos)
      },
      err => {
        console.log(err);
      });
  } 

  eliminarExperiencia(id: string) {
    this.datosPortfolio.eliminarExperiencia('id').subscribe(
      data => {
        this.toaster.success('Experiencia eliminada', 'OK', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.datosPortfolio.obtenerDatos();
      },
      err => {
        this.toaster.error('Fallo al eliminar la experiencia', 'Fail', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
      }
    );
  }

}
