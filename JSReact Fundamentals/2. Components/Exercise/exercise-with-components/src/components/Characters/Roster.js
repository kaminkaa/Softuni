import React from 'react';

export default class Roster extends React.Component {
    constructor(props) {
        super(props);
    }
    render = () => {
        const images = this.props.images.map(image => (
            <div key={image.id} className="roster-image-container">
                <img src={image.url} onClick={() => this.props.select(image.id)} />
            </div>
        ));

        return (
            <section id="roster">
                {images}
            </section>
        )
    }
}