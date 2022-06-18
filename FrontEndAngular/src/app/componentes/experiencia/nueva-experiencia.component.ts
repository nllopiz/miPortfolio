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
  //form: FormGroup;

  titulo: string = '';
  periodo: string = '';
  pathLogo: string = '';
  descripcion: string = '';

  constructor(
    //private formBuilder: FormBuilder,
    private datosPortfolioServicio: DatosPorfolioService,
    private toaster: ToastrService,
    private rutas: Router
  ) {
    /*
    this.form = this.formBuilder.group(
      {      }
    )*/
  }

  ngOnInit(): void {
  }

  onCreate(): void {
    //event.preventDefault;
    const experiencia = new Experiencia(this.titulo, this.periodo, this.pathLogo, this.descripcion);
    this.datosPortfolioServicio.nuevaExperiencia(experiencia).subscribe(
      data => {
        this.toaster.success('Experiencia creada', 'OK', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['./experiencia']);
      },
      err => {
        this.toaster.error('Fallo al crear la experiencia', 'Fail', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['/experiencia']);
      }
    )
  }

}
