import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { AutenticacionService } from 'src/app/servicios/autenticacion.service';
import { DatosPorfolioService } from 'src/app/servicios/datos-porfolio.service';

@Component({
  selector: 'app-proyectos',
  templateUrl: './proyectos.component.html',
  styleUrls: ['./proyectos.component.css']
})
export class ProyectosComponent implements OnInit {

  proyectos:any;
  usuarioAutenticado: any;

  constructor(
    private datosPortfolioServicio: DatosPorfolioService, 
    private autenticacionServicio: AutenticacionService,
    private toaster: ToastrService
  ) { }

  ngOnInit(): void {
    this.datosPortfolioServicio.verProyectos().subscribe(data => {
      this.proyectos = data;
      console.log(this.proyectos);
    },
    err => {
      console.log(err);
    }
    );
    this.usuarioAutenticado = this.autenticacionServicio.usuarioAutenticado.tokenDeAcceso;
  }

  onDelete(id: number): void {
    console.log('Borrar proyecto ' + id);
    this.datosPortfolioServicio.eliminarProyecto(id).subscribe(
      data => {
        this.ngOnInit();
      },
      err => {
        console.log('eliminado');
        this.toaster.success('Proyecto eliminado', 'OK', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.ngOnInit();
      }
    );
  } 

}
