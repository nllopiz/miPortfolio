import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { AutenticacionService } from 'src/app/servicios/autenticacion.service';
import { DatosPorfolioService } from 'src/app/servicios/datos-porfolio.service';

@Component({
  selector: 'app-formacion',
  templateUrl: './formacion.component.html',
  styleUrls: ['./formacion.component.css']
})

export class FormacionComponent implements OnInit {

  formaciones:any;
  usuarioAutenticado: any;

  constructor(
    private datosPortfolioServicio: DatosPorfolioService, 
    private autenticacionServicio: AutenticacionService,
    private toaster: ToastrService
  ) { }

  ngOnInit(): void {
    this.datosPortfolioServicio.verFormaciones().subscribe(data => {
      this.formaciones = data;
    },
    err => {
      console.log(err);
    }
    );
    this.usuarioAutenticado = this.autenticacionServicio.usuarioAutenticado.tokenDeAcceso;
  }

  onDelete(id: number): void {
    console.log('Borrar formacion ' + id);
    this.datosPortfolioServicio.eliminarFormacion(id).subscribe(
      data => {
        this.ngOnInit();
      },
      err => {
        console.log('eliminado');
        this.toaster.success('Formación eliminada', '', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.ngOnInit();
      }
    );
  }
}
