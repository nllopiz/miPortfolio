import { Component, OnInit } from '@angular/core';
import { ChartData, ChartOptions } from 'chart.js';


@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {

  skillsData: ChartData<'doughnut'> = {
    labels: [],
    datasets: [{
      label: 'HTML', 
      data: [75, 25],
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

  chartOptions: ChartOptions = {
    responsive: true,
    plugins: {
      title: {
        display: false,
        text: 'HTML Title'
      },
    },
  };

  constructor() { }

  ngOnInit(): void {
  }

}
