import { Component, OnInit, OnDestroy } from '@angular/core';
import { trigger, transition, style, animate } from '@angular/animations';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  animations: [
    trigger('fadeAnimation', [
      transition('* => *', [
        style({ opacity: 0 }),
        animate('500ms', style({ opacity: 1 })),
      ]),
    ]),
  ],
})
export class HomeComponent implements OnInit, OnDestroy {
  slides = [
    {
      image: 'https://www.top-finance.net/website_event/static/src/img/event_cover_4.jpg',
      alt: 'Conference hall',
      caption: 'Join us for exciting scientific discussions'
    },
    {
      image: 'https://www.sadovaya-hotel.ru/storage/2023/05/17/5c089bd996cf32fda248f3db5b499a1b63c5b3b2.jpg',
      alt: 'Scientists collaborating',
      caption: 'Connect with leading researchers'
    },
    {
      image: 'https://avatars.mds.yandex.net/i?id=4cd76840dfc5f766447232a9b146d30edc03cba7-4756639-images-thumbs&n=13',
      alt: 'Presentation',
      caption: 'Discover groundbreaking research'
    },
  ];

  currentSlide = 0;
  private slideInterval: any;

  ngOnInit() {
    this.startSlideshow();
  }

  ngOnDestroy() {
    this.stopSlideshow();
  }

  startSlideshow() {
    this.slideInterval = setInterval(() => {
      this.currentSlide = (this.currentSlide + 1) % this.slides.length;
    }, 5000);
  }

  stopSlideshow() {
    if (this.slideInterval) {
      clearInterval(this.slideInterval);
    }
  }

  changeSlide(index: number) {
    this.currentSlide = index;
    this.resetSlideshow();
  }

  resetSlideshow() {
    this.stopSlideshow();
    this.startSlideshow();
  }
}
