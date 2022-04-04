import { Component, OnInit } from '@angular/core';
import { ChartData, ChartDataset, ChartOptions, ChartType } from 'chart.js';
import { DatosPorfolioService } from 'src/app/servicios/datos-porfolio.service';


@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {

  public misdatos: any;

/*  public chartOptions: ChartOptions = {
      responsive: true,
      plugins: {
        title: {
          display: false,
          text: 'HTML'
        },
      },
    };

  public skillsData: ChartData<'doughnut'> = {
    labels: [],
    datasets: [{
      label: 'HTML', 
      data: [70,30],
      backgroundColor: [
        '#E31B25',
        '#1C1C1C'
    ],
    borderColor: [
      '#aaa'
    ],
    borderWidth: 1
    }],
  };
*/

  graficoChartOptions: ChartOptions = {responsive: true};
  graficoChartType: ChartType = 'doughnut';
  graficoChartDataSet: ChartDataset[] = [];
  graficoChartLabels: String[] = [];
  
  constructor(private datosPortfolio: DatosPorfolioService) {
    this.datosPortfolio.obtenerDatos().subscribe(data => {
      this.misdatos = data;
      for (const porc of this.misdatos.skills) {
        this.graficoChartDataSet.push ({data: porc.porcentaje});
        this.graficoChartLabels.push(porc.skill)
      }
      //console.log(this.graficoChartDataSet);
      //console.log(this.graficoChartLabels);
    });
   }

  ngOnInit(): void {
    
  }

  

  
}
