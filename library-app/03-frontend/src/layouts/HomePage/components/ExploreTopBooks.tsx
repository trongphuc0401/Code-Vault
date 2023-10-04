/* eslint-disable jsx-a11y/anchor-has-content */
/* eslint-disable jsx-a11y/anchor-is-valid */

import { Link } from "react-router-dom";

/* eslint-disable jsx-a11y/heading-has-content */
export const ExploreTopBook = () => {
  return (
    <div className="p-5 mb-4 bg-dark header">
      <div
        className="container-fluid py-5 text-white 
        d-flex justify-content-center align-items-center ">
        <div>
          <h1 className="display-5 fw-bold">Find your next adventure</h1>
          <p className="col-md-8 fs-4">Where would you like to go next</p>
          <Link
            type="button"
            className="btn main-color btn-lg text-white"
            to="/search"
          >Explore top books</Link>
        </div>
      </div>
    </div>
  );
};
