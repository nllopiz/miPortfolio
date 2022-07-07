import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { AutenticacionService } from 'src/app/servicios/autenticacion.service';
import { DatosPorfolioService } from 'src/app/servicios/datos-porfolio.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {

  public experiencias: any;
  usuarioAutenticado: any;

  constructor(
    private datosPortfolioServicio: DatosPorfolioService, 
    private autenticacionServicio: AutenticacionService,
    private toaster: ToastrService
  ) { }

  ngOnInit(): void {

    this.datosPortfolioServicio.verExperiencias().subscribe(
      data => {
      this.experiencias = data; 
      console.log(this.experiencias);
      },
      err => {
        console.log(err);
      }
    );
    this.usuarioAutenticado = this.autenticacionServicio.usuarioAutenticado.tokenDeAcceso;

  } 
 
  onDelete(id: number): void {
    console.log('Borrar experiencia ' + id);
    this.datosPortfolioServicio.eliminarExperiencia(id).subscribe(
      data => {
        this.ngOnInit();
      },
      err => {
        console.log('eliminado');
        this.toaster.success('Experiencia eliminada', 'OK', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.ngOnInit();
      }
    );
  }

}
