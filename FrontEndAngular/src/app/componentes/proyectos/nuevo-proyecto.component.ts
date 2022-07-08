import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Proyecto } from 'src/app/modelos/proyecto';
import { DatosPorfolioService } from 'src/app/servicios/datos-porfolio.service';

@Component({
  selector: 'app-nuevo-proyecto',
  templateUrl: './nuevo-proyecto.component.html',
  styleUrls: ['./nuevo-proyecto.component.css']
})
export class NuevoProyectoComponent implements OnInit {

  titulo: string = '';
  pathImage: string = '';
  descripcion: string = '';
  link: string = '';
  github: string = '';

  constructor(
    private datosPortfolioServicio: DatosPorfolioService,
    private toaster: ToastrService,
    private rutas: Router
  ) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const proyecto = new Proyecto(this.titulo, this.pathImage, this.descripcion, this.link, this.github);
    this.datosPortfolioServicio.nuevoProyecto(proyecto).subscribe(
      data => {
        this.toaster.success('Proyecto creado', '', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['./proyectos']);
      },
      err => {
        this.toaster.error('Fallo al crear el proyecto', 'Error', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['/proyectos']);
      }
    )
  }

}
