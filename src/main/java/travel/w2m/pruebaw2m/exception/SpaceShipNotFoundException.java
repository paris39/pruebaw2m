package travel.w2m.pruebaw2m.exception;

public class SpaceShipNotFoundException extends Exception {

	/**
	 * Instantiates a new space ship not found exception.
	 */
	public SpaceShipNotFoundException () {
		super();
	}

	/**
	 * Instantiates a new space ship not found exception.
	 *
	 * @param message
	 *        the message
	 * @param throwable
	 *        the throwable
	 */
	public SpaceShipNotFoundException (String message, Throwable throwable) {
		super(message, throwable);
	}

	/**
	 * Instantiates a new space ship not found exception.
	 *
	 * @param message
	 *        the message
	 */
	public SpaceShipNotFoundException (String message) {
		super(message);
	}

	/**
	 * Instantiates a new space ship not found exception.
	 *
	 * @param throwable
	 *        the throwable
	 */
	public SpaceShipNotFoundException (Throwable throwable) {
		super(throwable);
	}

}