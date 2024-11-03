package org.programmingGame.error;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

// result monad (・∀・)
public class Result<T> {
	public final Optional<T> ok;
	public final Optional<GameError> err;

	public Optional<Consumer<T>> onOk;
	public Optional<Consumer<GameError>> onErr;

	public Result(T ok) {
		this.ok = Optional.of(ok);
		this.err = Optional.empty();
	}

	public Result(GameError err) {
		this.err = Optional.of(err);
		this.ok = Optional.empty();
	}

	public Result(T ok, Optional<Consumer<T>> runOk, Optional<Consumer<GameError>> runErr) {
		this.ok = Optional.of(ok);
		this.err = null;

		onOk = runOk;
		onErr = runErr;
	}

	public Result(GameError err, Optional<Consumer<T>> runOk, Optional<Consumer<GameError>> runErr) {
		this.err = Optional.of(err);
		this.ok = Optional.empty();

		onOk = runOk;
		onErr = runErr;
	}

	public void ifOk(Consumer<T> run) {
		ok.ifPresent(a -> run.accept(a));
	}

	public void ifErr(Consumer<GameError> run) {
		err.ifPresent(a -> run.accept(a));
	}

	public <E> Result<E> map(Function<T, E> mapper) { // maps the inner value
		if (!ok.isEmpty())
			return new Result<E>(mapper.apply(ok.get()));
		else
			return new Result<E>(err.get());
	}

	public T unwrap(Function<GameError, T> errorMap) {
		if (!ok.isEmpty())
			return ok.get();
		else
			return errorMap.apply(err.get());
	}

	// runs predefined functions on the result if set, does nothing if not set
	public void run() {
		if (!onOk.isEmpty() && !isErr())
			onOk.get().accept(ok.get());
		if (!onOk.isEmpty() && isErr())
			onErr.get().accept(err.get());
	}

	public boolean isErr() {
		return !err.isEmpty();
	}
}
