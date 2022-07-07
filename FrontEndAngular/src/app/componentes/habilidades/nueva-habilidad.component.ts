import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Habilidad } from 'src/app/modelos/habilidad';
import { DatosPorfolioService } from 'src/app/servicios/datos-porfolio.service';

@Component({
  selector: 'app-nueva-habilidad',
  templateUrl: './nueva-habilidad.component.html',
  styleUrls: ['./nueva-habilidad.component.css']
})
export class NuevaHabilidadComponent implements OnInit {

  nombre: string = '';
  porcentajes: string = '';

  constructor(
    private datosPortfolioServicio: DatosPorfolioService,
    private toaster: ToastrService,
    private rutas: Router
  ) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const habilidad = new Habilidad(this.nombre, this.porcentajes);
    this.datosPortfolioServicio.nuevaHabilidad(habilidad).subscribe(
      data => {
        this.toaster.success('Habilidad creada', 'OK', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['./habilidades']);
      },
      err => {
        this.toaster.error('Fallo al crear la habilidad', 'Fail', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['/habilidades']);
      }
    )
  }

}
