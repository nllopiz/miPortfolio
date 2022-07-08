import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Experiencia } from 'src/app/modelos/experiencia';
import { DatosPorfolioService } from 'src/app/servicios/datos-porfolio.service';
import { ToastrService } from 'ngx-toastr';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-nueva-experiencia',
  templateUrl: './nueva-experiencia.component.html',
  styleUrls: ['./nueva-experiencia.component.css']
})
export class NuevaExperienciaComponent implements OnInit {

  titulo: string = '';
  periodo: string = '';
  pathLogo: string = '';
  descripcion: string = '';

  constructor(
    private datosPortfolioServicio: DatosPorfolioService,
    private toaster: ToastrService,
    private rutas: Router
  ) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const experiencia = new Experiencia(this.titulo, this.periodo, this.pathLogo, this.descripcion);
    this.datosPortfolioServicio.nuevaExperiencia(experiencia).subscribe(
      data => {
        this.toaster.success('Experiencia creada', '', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['./experiencia']);
      },
      err => {
        this.toaster.error('Fallo al crear la experiencia', 'Error', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['/experiencia']);
      }
    )
  }

}
