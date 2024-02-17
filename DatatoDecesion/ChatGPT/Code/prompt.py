import openai
import streamlit as st
from streamlit.logger import get_logger
from dotenv import load_dotenv
import os
# Set your OpenAI organization ID and API key

load_dotenv()

openai.api_key = os.getenv('API_KEY')

LOGGER = get_logger(__name__)

def create_classroom_survey_form(audience, personal_details, form_theme, allow_file_upload, allow_image_upload):
    """
    Generates a classroom survey form based on specified parameters.
    
    Parameters:
    - audience: The target audience for the form (e.g., students, teachers).
    - personal_details: A list of personal detail fields to include in the form.
    - form_theme: The theme of the form (e.g., light, dark) to customize appearance.
    - allow_file_upload: Boolean indicating if file uploads are allowed.
    - allow_image_upload: Boolean indicating if image uploads are allowed.
    """
    content_prompt = (
        "Create an HTML form for a classroom survey tailored to {audience}. "
        "Include fields for {details}. Use a {theme} theme, ensuring good contrast between background and text. "
        "Ensure the form includes labels, input types, and IDs for all fields. Add validation for fields like email and phone numbers. "
        .format(
            audience=audience,
            details=', '.join(personal_details),
            theme=form_theme,
            file_upload='enabled' if allow_file_upload else 'disabled',
            image_upload='enabled' if allow_image_upload else 'disabled'
        )
    )

    try:
        content_response = openai.Completion.create(
            model="gpt-3.5-turbo",
            prompt=content_prompt,
            temperature=0.5,  # A more deterministic output
            max_tokens=1500
        )

        content = content_response.choices[0].text
        return content
    except Exception as e:
        LOGGER.error(f"Failed to generate form: {e}")
        return str(e)
