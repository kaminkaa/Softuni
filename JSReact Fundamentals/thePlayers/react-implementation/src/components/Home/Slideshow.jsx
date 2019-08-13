import React, { Component } from 'react';
import '../../style/slideshow.css';

let slideIndex = 1;

export default class Slideshow extends Component {
    constructor(props) {
        super(props);

        this.showSlides = this.showSlides.bind(this);
    }

    componentDidMount() {
        this.showSlides(slideIndex);
    }

    showSlides(n) {
        let i;
        let slides = document.getElementsByClassName("mySlides");
        let dots = document.getElementsByClassName("dot");
        if (n > slides.length) {
            slideIndex = 1
        }
        if (n < 1) {
            slideIndex = slides.length
        }
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }
        slides[slideIndex - 1].style.display = "block";
        dots[slideIndex - 1].className += " active";
    }

    plusSlides(n) {
        this.showSlides(slideIndex += n);
    }

    currentSlide(n) {
        this.showSlides(slideIndex = n);
    }

    render() {
        return (
            <div>
                <div className="slideshow-container">

                    <div className="mySlides">
                        <img src={require('../../images/1.jpg')} alt=""/>
                        <div className="text">Luka Modrić</div>
                    </div>

                    <div className="mySlides">
                        <img src={require('../../images/2.jpg')} alt=""/>
                        <div className="text">Thibaut Courtois</div>
                    </div>

                    <div className="mySlides">
                        <img src={require('../../images/3.jpg')} alt=""/>
                        <div className="text">Kevin De Bruyne</div>
                    </div>

                    <a className="prev" onClick={ () => this.plusSlides(-1) }>&#10094;</a>
                    <a className="next" onClick={ () => this.plusSlides(1)} >&#10095;</a>
                </div>
                <br/>

                <div className="dots">
                    <span className="dot" onClick={ () => this.currentSlide(1) }/>
                    <span className="dot" onClick={ () => this.currentSlide(2) }/>
                    <span className="dot" onClick={ () => this.currentSlide(3) }/>
                </div>
            </div>
        )
    }
}