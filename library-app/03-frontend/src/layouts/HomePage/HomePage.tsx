import React   from "react";

import { Carousel } from "./components/Carousel";
import { ExploreTopBook } from "./components/ExploreTopBooks";
import { Heros } from "./components/Heros";
import { LibraryServices } from "./components/LibraryServices";

export const HomePage = () => {
    return (
        <>
        <ExploreTopBook/>
        <Carousel/>
        <Heros/>
        <LibraryServices/>
        </>

    );
}