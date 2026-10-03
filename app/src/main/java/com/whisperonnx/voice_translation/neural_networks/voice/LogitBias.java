package com.whisperonnx.voice_translation.neural_networks.voice;

/**
 * kxkb: a hook into the greedy decoder (single-language path) that may raise token scores before the pick —
 * the host keyboard uses it to favour the words of the user's own vocabulary (shallow fusion). All three
 * calls arrive on the recognizer's thread, in order, for one transcription at a time.
 */
public interface LogitBias {
    /** A new transcription starts. */
    void reset();

    /** Adjust the raw logits of the next text token in place. */
    void adjust(float[] logits);

    /** The decoder picked [token] (a text token, below end-of-text). */
    void accept(int token);
}
