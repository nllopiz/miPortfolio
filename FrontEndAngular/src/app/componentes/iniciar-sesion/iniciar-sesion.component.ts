import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { AutenticacionService } from 'src/app/servicios/autenticacion.service';

@Component({
  selector: 'app-iniciar-sesion',
  templateUrl: './iniciar-sesion.component.html',
  styleUrls: ['./iniciar-sesion.component.css']
})
export class IniciarSesionComponent implements OnInit {
  form: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private autenticacioService: AutenticacionService,
    private toaster: ToastrService,
    private ruta: Router
  ) {
    this.form = this.formBuilder.group(
      {
        email: ['', [Validators.required, Validators.email]],
        password: ['', [Validators.required, Validators.minLength(8)]]
      }
    )
  }

  ngOnInit(): void {
  }

  get Email() {
    return this.form.get('email');
  }

  get Password() {
    return this.form.get('password');
  }

  onEnviar(event: Event) {
    event.preventDefault;
    this.autenticacioService.IniciarSesion(this.form.value).subscribe(data => {
      this.toaster.success('Sesión iniciada', '', {
        timeOut: 3800, positionClass: 'toast-top-center'
      });
      console.log("DATA:" + JSON.stringify(data));
      this.ruta.navigate(['../acerca-de']);
    },
    err => {
      this.toaster.error('Usuario y/o clave incorrecto', 'Error', {
        timeOut: 3800, positionClass: 'toast-top-center'
      });
      this.ruta.navigate(['/iniciar-sesion']);
    }
    )
  }

}
