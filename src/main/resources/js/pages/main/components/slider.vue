<template>
    <div class="mb-5">
        <b-carousel
                id="carousel-1"
                v-model="slide"
                :interval="4000"
                controls
                indicators
                background="#ababab"
                img-width="1024"
                img-height="480"
                style="text-shadow: 1px 1px 2px #333;"
                @sliding-start="onSlideStart"
                @sliding-end="onSlideEnd"
        >
            <!-- Text slides with image -->
            <b-carousel-slide
                    caption="First slide"
                    text="Nulla vitae elit libero, a pharetra augue mollis interdum."
                    img-src="http://seadev.kz/img/32797a3c-78ab-4b0a-a490-720cc888a5ee.Group 19.jpg"
            />

            <!-- Slide with blank fluid image to maintain slide aspect ratio -->
<!--            <b-carousel-slide caption="Blank Image" img-blank img-alt="Blank image">-->
<!--                <p>-->
<!--                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse eros felis, tincidunt-->
<!--                    a tincidunt eget, convallis vel est. Ut pellentesque ut lacus vel interdum.-->
<!--                </p>-->
<!--            </b-carousel-slide>-->
        </b-carousel>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                slide: 0,
                sliding: null
            }
        },
        methods: {
            onSlideStart(slide) {
                this.sliding = true
            },
            onSlideEnd(slide) {
                this.sliding = false
            }
        }
    }
</script>