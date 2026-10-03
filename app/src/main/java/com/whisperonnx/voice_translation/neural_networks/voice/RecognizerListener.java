/*
 * Copyright 2016 Luca Martino.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copyFile of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.whisperonnx.voice_translation.neural_networks.voice;


import com.whisperonnx.voice_translation.neural_networks.NeuralNetworkApiListener;

public interface RecognizerListener extends NeuralNetworkApiListener {
    void onSpeechRecognizedResult(String text, String languageCode, double confidenceScore, boolean isFinal);

    /**
     * kxkb: the same result plus the raw words of the transcription (before the capitalisation /
     * timestamp clean-up) with each word's lowest token probability; both arrays are null when the
     * confidences could not be computed. Defaults to the plain callback.
     */
    default void onSpeechRecognizedWords(String text, String languageCode, double confidenceScore, boolean isFinal,
                                         String[] words, float[] wordConfidences) {
        onSpeechRecognizedResult(text, languageCode, confidenceScore, isFinal);
    }
}
