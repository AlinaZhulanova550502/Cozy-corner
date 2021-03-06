package bsuir.vintsarevich.buisness.review.service.impl;

import bsuir.vintsarevich.buisness.review.dao.IReviewDao;
import bsuir.vintsarevich.buisness.review.service.IReviewService;
import bsuir.vintsarevich.entity.Review;
import bsuir.vintsarevich.exception.dao.DaoException;
import bsuir.vintsarevich.exception.service.ServiceException;
import bsuir.vintsarevich.factory.dao.DaoFactory;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.List;


/**
 * class ReviewService created for preparation data before sending queries to database table "review"
 */
public class ReviewService implements IReviewService {
    private static final Logger LOGGER = Logger.getLogger(ReviewService.class);
    private static final IReviewDao reviewDao = DaoFactory.getInstance().getReviewDao();

    /**
     * @param text
     * @param mark
     * @param clientId
     * @return boolean
     * @throws ServiceException
     */
    @Override
    public boolean addReview(String text, Double mark, Integer clientId) throws ServiceException {
        LOGGER.log(Level.DEBUG, "Review Service: start addReview");
        Review review = new Review(text, mark, clientId);
        try {
            LOGGER.log(Level.DEBUG, "Review Service: finish addReview");
            return reviewDao.addReview(review);
        } catch (DaoException e) {
            throw new ServiceException(this.getClass() + ":" + e.getMessage());
        }
    }

    /**
     * @param reviewId
     * @return boolean
     * @throws ServiceException
     */
    @Override
    public boolean deleteReview(Integer reviewId) throws ServiceException {
        LOGGER.log(Level.DEBUG, "Review Service: start deleteReview");
        try {
            LOGGER.log(Level.DEBUG, "Review Service: finish deleteReview");
            return reviewDao.deleteReview(reviewId);
        } catch (DaoException e) {
            throw new ServiceException(this.getClass() + ":" + e.getMessage());
        }
    }

    /**
     * @return List<Review>
     * @throws ServiceException
     */
    @Override
    public List<Review> getAllReviews() throws ServiceException {
        LOGGER.log(Level.DEBUG, "Review Service: start getAllReviews");
        try {
            LOGGER.log(Level.DEBUG, "Review Service: finish getAllReviews");
            return reviewDao.getAllReviews();
        } catch (DaoException e) {
            throw new ServiceException(this.getClass() + ":" + e.getMessage());
        }
    }
}
